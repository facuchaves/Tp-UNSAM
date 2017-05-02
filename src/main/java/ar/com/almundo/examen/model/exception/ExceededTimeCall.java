/**
 * 
 */
package ar.com.almundo.examen.model.exception;

/**
 * @author facundo.lopez
 *
 */
public class ExceededTimeCall extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceededTimeCall() {
		super();
	}
	
	public ExceededTimeCall(String message) {
		super(message);
	}
	
}
