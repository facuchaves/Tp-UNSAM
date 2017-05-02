/**
 * 
 */
package ar.com.almundo.examen.model;

import java.util.List;
import java.util.Optional;

import ar.com.almundo.examen.model.exception.NotEmployeesPresent;

/**
 * @author facundo.lopez
 *
 */
public class CallCenter {
	
	private List<Employee> employees;
	private String name;
	
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
	 */
	public void takeCall(Call call) throws NotEmployeesPresent{
		
		System.out.println("Taken call " + call.getId() + " in callcenter " + name);
		
		Optional<Employee> employeeToTakeCall = getEmployees().stream().findFirst();//TODO Agregar comparador por tipo de clase.
		
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
	
}
