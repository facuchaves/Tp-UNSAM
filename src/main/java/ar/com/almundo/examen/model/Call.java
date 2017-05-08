/**
 * 
 */
package ar.com.almundo.examen.model;

import java.util.Random;

/**
 * @author facundo.lopez
 *
 */
public class Call {
	private Long id;
	private CallStatus callStatus;
	private String origin;
	private Long maxDuration;//Expresed in miliseconds

	public Call() {
		Random random =  new Random();
		
		maxDuration = ( 5000l + ( 5000l * (long)random.nextDouble() ) );
		callStatus = CallStatus.NEW;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CallStatus getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(CallStatus callStatus) {
		this.callStatus = callStatus;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public Long getMaxDuration() {
		return maxDuration;
	}
	
	public void setMaxDuration(Long maxDuration) {
		this.maxDuration = maxDuration;
	}
	
}
