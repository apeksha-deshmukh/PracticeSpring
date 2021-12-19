package com.example.demo.exception;



public class LowerVersionNotAllowed extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LowerVersionNotAllowed(String msg) {
		
		super(msg);
	}

}
