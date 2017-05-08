/**
 * 
 */
package ar.com.almundo.examen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import ar.com.almundo.examen.model.exception.NotEmployeesPresent;
import ar.com.almundo.examen.model.utils.Utils;

/**
 * @author facundo.lopez
 *
 */
public class CallCenter {
	
	private List<Employee> employees = new ArrayList<Employee>();
	private String name;
	private Logger logger = Logger.getRootLogger();
	
	/**
	 * 
	 * The employees take a call in this order
	 * 
	 * <ul>
	 * 	<li> 1) Operator </li>
	 * 	<li> 2) Supervisor </li>
	 * 	<li> 3) Director </li>
	 * </ul>
	 * 
	 * Otherway, throw an exception.
	 * 
	 * @param call
	 * @throws NotEmployeesPresent 
	 * @throws InterruptedException 
	 */
	public void takeCall(Call call) throws NotEmployeesPresent{
		
		System.out.println("Taken call " + call.getId() + " in callcenter " + name);
		
		Optional<Employee> employeeToTakeCall = Utils.findEmpleyeeToTakeCall( getEmployees() );
		
		if( !employeeToTakeCall.isPresent() ){
			System.err.println("There is no employee to take call " + call.getId());
			throw new NotEmployeesPresent("There is no employee to take call " + call.getId());
		}
		
		employeeToTakeCall.get().takeCall(call);
		
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee){
		employees.add(employee);
	}
}
