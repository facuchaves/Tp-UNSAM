/**
 * 
 */
package ar.com.almundo.examen;

import org.junit.Assert;
import org.junit.Test;

import ar.com.almundo.examen.model.Call;
import ar.com.almundo.examen.model.CallCenter;
import ar.com.almundo.examen.model.CallStatus;
import ar.com.almundo.examen.model.Director;
import ar.com.almundo.examen.model.Employee;
import ar.com.almundo.examen.model.Operator;
import ar.com.almundo.examen.model.Supervisor;
import ar.com.almundo.examen.model.exception.NotEmployeesPresent;

/**
 * @author facundo.lopez
 *
 */
public class CallCenterTest {
	
	CallCenter callCenter = new CallCenter();
	Call call = new Call();
	
	/*
	 * Test a call ok
	 */
	@Test
	public void takeCallOkTest() throws Exception{
		takeCall(new Operator());
		
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
	}

	private void takeCall(Employee employee) throws Exception {
		callCenter.addEmployee( employee );
		
		callCenter.takeCall(call);
	}
	
	/*
	 * Test error when no are employees
	 */
	@Test(expected=NotEmployeesPresent.class)
	public void takeCallWithoutEmplyeeTest() throws Exception{
		callCenter.takeCall(call);
	}
	
	/*
	 * Test that the call is taken by a operator
	 */
	@Test
	public void takeCallOperatorTest() throws Exception{
		takeCall(new Operator());
		
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
	}
	
	/*
	 * Test that the call is taken by a supervisor
	 */
	@Test
	public void takeCallSupervisorTest() throws Exception{
		takeCall(new Supervisor());
		
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
	}
	
	/*
	 * Test that the call is taken by a director
	 */
	@Test
	public void takeCallDirectorTest() throws Exception{
		takeCall(new Director());
		
		Assert.assertEquals(CallStatus.END, call.getCallStatus());	
	}
}
