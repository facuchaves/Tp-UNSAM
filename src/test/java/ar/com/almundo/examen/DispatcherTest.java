/**
 * 
 */
package ar.com.almundo.examen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.com.almundo.examen.model.Call;
import ar.com.almundo.examen.model.CallCenter;
import ar.com.almundo.examen.model.CallStatus;
import ar.com.almundo.examen.model.Dispatcher;
import ar.com.almundo.examen.model.Operator;

/**
 * @author facundo.lopez
 *
 */
public class DispatcherTest {
	
	Dispatcher dispatcher;
	
	@Before
	public void init(){
		dispatcher = new Dispatcher();
		
		CallCenter callCenter = new CallCenter();
		
		for(int i = 0 ; i < 10 ; i++){
			callCenter.addEmployee( new Operator());
		}
		
		dispatcher.setCallCenter( callCenter );
	}
	
	@Test
	public void test1Call() throws Exception{
		Call call = new Call();
		dispatcher.dispatchCall( call );
		Thread.sleep(10000);
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
	}
	
	@Test
	public void test10CallsOk() throws Exception{
		for( int i = 0 ; i < 10 ; i++){
			dispatcher.dispatchCall( new Call() );
		}
		Thread.sleep(4000);
		Assert.assertFalse( dispatcher.hasPendingCalls() );
	}
	
	@Test
	public void test11CallsOk() throws Exception{
		for( int i = 0 ; i < 11 ; i++){
			dispatcher.dispatchCall( new Call() );
		}
		Thread.sleep(4000);
		Assert.assertTrue( dispatcher.hasPendingCalls() );
	}
	
	@Test
	public void testRety11CallsOk() throws Exception{
		for( int i = 0 ; i < 10 ; i++){
			dispatcher.dispatchCall( new Call() );
		}
		Thread.sleep(25000);
		Assert.assertFalse( dispatcher.hasPendingCalls() );
	}
	
}
