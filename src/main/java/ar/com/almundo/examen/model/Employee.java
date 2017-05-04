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
	private Logger logger = Logger.getLogger( Employee.class );
	private Hierarchy hierarchy;
	
	
	/**
	 * The employee take a call from parameters.
	 * 
	 * @param call
	 * @throws InterruptedException 
	 */
	public void takeCall(Call call) throws InterruptedException{
		System.out.println("Employee " + name + " take call " + call.getId() );
		call.setCallStatus(CallStatus.IN_PROGRESS);
	
		//Some logic here
		Thread.sleep( call.getMaxDuration() );
		
		call.setCallStatus(CallStatus.END);
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
	
}
