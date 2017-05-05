/**
 * 
 */
package ar.com.almundo.examen;

import org.junit.Assert;
import org.junit.Test;

import ar.com.almundo.examen.model.Call;
import ar.com.almundo.examen.model.CallStatus;
import ar.com.almundo.examen.model.Director;
import ar.com.almundo.examen.model.EmployeeStatus;
import ar.com.almundo.examen.model.Operator;
import ar.com.almundo.examen.model.Supervisor;

/**
 * @author facundo.lopez
 *
 */
public class EmployeeTest {
	
	Call call = new Call();
	Operator operator = new Operator();;
	Supervisor supervisor = new Supervisor();;
	Director director = new Director();
	
	@Test
	public void testOperatorTakeOkCall() throws Exception{
		operator.takeCall(call);
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
		Assert.assertEquals(EmployeeStatus.AVAILABLE, operator.getEmployeeStatus());
	}
	
	@Test
	public void testSupervisorTakeOkCall() throws Exception{
		supervisor.takeCall(call);
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
		Assert.assertEquals(EmployeeStatus.AVAILABLE, supervisor.getEmployeeStatus());
	}
	
	@Test
	public void testDirectorTakeOkCall() throws Exception{
		director.takeCall(call);
		Assert.assertEquals(CallStatus.END, call.getCallStatus());
		Assert.assertEquals(EmployeeStatus.AVAILABLE, director.getEmployeeStatus());
	}
}
