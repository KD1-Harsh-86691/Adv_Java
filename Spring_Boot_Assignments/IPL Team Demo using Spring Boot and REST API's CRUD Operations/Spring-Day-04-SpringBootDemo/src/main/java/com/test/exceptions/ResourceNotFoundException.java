package com.test.exceptions;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException(String errMesg) {
		
		super(errMesg);
		System.out.println("Exception : " + errMesg);
		
		
	}
	
}
