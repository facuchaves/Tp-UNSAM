/**
 * 
 */
package ar.com.almundo.examen.model.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.com.almundo.examen.model.Employee;
import ar.com.almundo.examen.model.EmployeeStatus;

/**
 * @author facundo.lopez
 *
 */
public class Utils {
	
	public static synchronized Optional<Employee> findEmpleyeeToTakeCall(List<Employee> employees) {
		return employees.stream()
		.filter( employee -> EmployeeStatus.AVAILABLE.equals( employee.getEmployeeStatus() ) )
		.sorted( new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2){
				return e1.getHierarchy().compareTo( e2.getHierarchy() );
			}
		} )
		.findFirst();
	}
	
}
