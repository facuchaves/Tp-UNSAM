/**
 * 
 */
package ar.com.almundo.examen.model;

import org.apache.log4j.Logger;

/**
 * @author facundo.lopez
 *
 */
public abstract class Employee implements Comparable<Employee>{
	
	private String name;
	private Logger logger = Logger.getRootLogger();// Employee.class );
	private Hierarchy hierarchy;
	private EmployeeStatus employeeStatus;
	
	public Employee() {
		setEmployeeStatus( EmployeeStatus.AVAILABLE );
	}
	
	/**
	 * The employee take a call from parameters.
	 * 
	 * @param call
	 * @throws InterruptedException 
	 */
	public void takeCall(Call call) {
		System.out.println("Employee " + name + " take call " + call.getId() );
		call.setCallStatus(CallStatus.IN_PROGRESS);
		setEmployeeStatus( EmployeeStatus.BUSY );
		
		//Some logic here
		try {
			/*
			 *  Esto esta dentro de un try-catch, porque en realidad nunca se va a hacer un sleep, es simplemente para simularlo.
			 *  Con lo cual nunca se daria un InterruptedException y no quise ensuciar el codigo con throws en los metodos
			 */
			Thread.sleep( call.getMaxDuration() );   
		} catch (InterruptedException e) {
			System.err.println("Se interumpio la llamada.");
		}
		
		call.setCallStatus(CallStatus.END);
		setEmployeeStatus( EmployeeStatus.AVAILABLE );
		System.out.println("Employee " + name + " end call " + call.getOrigin() );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Hierarchy getHierarchy() {
		return hierarchy;
	}
	
	public void setHierarchy(Hierarchy hierarchy) {
		this.hierarchy = hierarchy;
	}
	
	public int compareTo(Employee otherEmployee) {
		return this.hierarchy.compareTo( otherEmployee.getHierarchy() );
	}
	
	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}
	
	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
}
