/**
 * 
 */
package ar.com.almundo.examen.model;

/**
 * @author facundo.lopez
 *
 */
public abstract class Employee {
	
	private String name;
	
	/**
	 * The employee take a call from parameters.
	 * 
	 * @param call
	 */
	public void takeCall(Call call){
		System.out.println("Employee " + name + " take call " + call.getId() );//TODO Esto deberia ser un logger
		call.setCallStatus(CallStatus.IN_PROGRESS);
	
		//Some logic here
		
		call.setCallStatus(CallStatus.END);
		System.out.println("Employee " + name + " end call " + call.getOrigin() );//TODO Esto deberia ser un logger
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
