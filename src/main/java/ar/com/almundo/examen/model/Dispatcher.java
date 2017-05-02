/**
 * 
 */
package ar.com.almundo.examen.model;

import ar.com.almundo.examen.model.exception.MaxConcurrrentCallsException;
import ar.com.almundo.examen.model.exception.NotEmployeesPresent;

/**
 * @author facundo.lopez
 *
 */
public class Dispatcher {
	
	private final int MAX_CALLS = 10;//TODO Esto podria estar en un archivo properties o en la  BBDD.
	private int quantityActualsCalls = 0;
	private CallCenter  callCenter;
	
	public void dispatchCall(Call call) throws MaxConcurrrentCallsException, NotEmployeesPresent{
		
		System.out.println("Distpaching call from origin " + call.getOrigin() );
		
		increaseQuantityCalls();

		if( quantityActualsCalls > 10 ){
			System.err.println("There are " + quantityActualsCalls + " and the max is " + MAX_CALLS);
			throw new MaxConcurrrentCallsException("There are " + quantityActualsCalls + " and the max is " + MAX_CALLS);
		}
		
		callCenter.takeCall(call);
	}

	private synchronized void increaseQuantityCalls() {
		quantityActualsCalls ++;
	}
	
}
