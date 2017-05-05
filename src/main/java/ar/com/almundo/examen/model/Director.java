/**
 * 
 */
package ar.com.almundo.examen.model;

/**
 * @author facundo.lopez
 *
 */
public class Director extends Employee {
	public Director() {
		super();
		setHierarchy( Hierarchy.DIRECTOR );
	}
}
