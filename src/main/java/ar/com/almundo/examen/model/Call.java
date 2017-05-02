/**
 * 
 */
package ar.com.almundo.examen.model;

import java.util.Random;

import ar.com.almundo.examen.model.exception.ExceededTimeCall;

/**
 * @author facundo.lopez
 *
 */
public class Call {
	private Long id;
	private CallStatus callStatus;
	private String origin;
	private Double maxDuration;

	public Call() {
		Random random =  new Random();//TODO Ver como evitar esto
		
		maxDuration = ( 5 + ( 5 * random.nextDouble() ) );
	}
	
	public void validate(){
//		if( duration > maxDuration ){
//			System.err.println("The call " + getId() + " exceeded the max duration. The max duration are " + maxDuration + " but the call dure " + duration);
//			throw new ExceededTimeCall();
//		}
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
	
}
