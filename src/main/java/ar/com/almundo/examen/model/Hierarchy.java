/**
 * 
 */
package ar.com.almundo.examen.model;

/**
 * @author facundo.lopez
 *
 */
public enum Hierarchy {
	
	OPEARTOR( 10 ),
	SUPERVISOR( 5 ),
	DIRECTOR( 1 );
	
	private Integer priority;

	private Hierarchy(Integer priority) {
		this.priority = priority;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	public int compareToCustom(Hierarchy otherHierarchy) {
		return this.priority.compareTo( otherHierarchy.priority );
	}

}
