/**
 * 
 */
package ar.com.almundo.examen.model.exception;

/**
 * This exception occurs when the limit of concurrents calls are overcome.
 * 
 * @author facundo.lopez
 *
 */
public class MaxConcurrrentCallsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MaxConcurrrentCallsException() {
		super();
	}
	
	public MaxConcurrrentCallsException(String message) {
		super(message);
	}
	
}
