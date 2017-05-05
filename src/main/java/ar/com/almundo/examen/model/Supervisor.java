/**
 * 
 */
package ar.com.almundo.examen.model;

/**
 * @author facundo.lopez
 *
 */
public class Supervisor extends Employee {
	public Supervisor() {
		super();
		setHierarchy( Hierarchy.SUPERVISOR );
	}
}
