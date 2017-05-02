/**
 * 
 */
package ar.com.almundo.examen.model.exception;

/**
 * This exception is throwen when there arent any employee to take a call.
 * 
 * @author facundo.lopez
 *
 */
public class NotEmployeesPresent extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEmployeesPresent() {
		super();
	}
	
	public NotEmployeesPresent(String message) {
		super(message);
	}
	
}
