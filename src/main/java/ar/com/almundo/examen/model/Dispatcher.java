/**
 * 
 */
package ar.com.almundo.examen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.log4j.Logger;

import ar.com.almundo.examen.model.exception.NotEmployeesPresent;

/**
 * @author facundo.lopez
 *
 */
public class Dispatcher {
	
	private final int MAX_CALLS = 10;//Esto podria estar en un archivo properties o en la  BBDD.
	private int quantityActualsCalls = 0;
	private CallCenter  callCenter = new CallCenter();
	private Logger logger = Logger.getRootLogger();
	private Queue<Call> pendingCalls = new LinkedBlockingDeque<Call>();
	private List<Future<?>> futures = new ArrayList<Future<?>>();
	
	public void dispatchCall(Call call) throws InterruptedException {
		
		System.out.println("Distpaching call from origin " + call.getOrigin() );

		takeNextPendingCall();

		if( quantityActualsCalls < MAX_CALLS ){
		
			increaseQuantityCalls();
			ExecutorService executor = Executors.newSingleThreadExecutor();
			futures.add( executor.submit(() -> {
				takeCall(call);
			}) );
		
		} else{
			
			System.out.println("The max number of calls are used. The call " + call.getId() + " is now in queue ");
			pendingCalls.add(call);
			
		}
//		for (@SuppressWarnings("unused") Future<?> future : futures) {
//			System.out.println("The thread " + Thread.currentThread() + "is now free.Try to take a pending call.");
//			takeNextPendingCall();
//		}
	}

	/**
	 * If has a pending call, take it.Otherway nothing is doing.
	 * @throws InterruptedException 
	 */
	private void takeNextPendingCall() {
		
		Call pendingCall = getNextPendingCall();
		
		if( pendingCall != null ){
			System.out.println("Taking pending call " + pendingCall.getId());
			
			increaseQuantityCalls();
			takeCall( pendingCall );
		}
		
	}
	
	private synchronized Call getNextPendingCall(){
		return pendingCalls.poll();
	}
	
	/**
	 * Take a call, if there are not employee available to take it, add the call to a list of pendings.
	 * 
	 * @param call
	 */
	private void takeCall(Call call) {
		
		try {
			callCenter.takeCall(call);
			decreaseQuantityCalls();
		} catch (NotEmployeesPresent e) {
			pendingCalls.add(call);
		}
		
	}

	private synchronized void increaseQuantityCalls() {
		quantityActualsCalls ++;
	}
	
	private synchronized void decreaseQuantityCalls() {
		quantityActualsCalls --;
	}
	
	public boolean hasPendingCalls(){
		return !pendingCalls.isEmpty();
	}
	
	public void setCallCenter(CallCenter callCenter) {
		this.callCenter = callCenter;
	}
	
}
