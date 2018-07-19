package com.pathfinder.exception;

/**
 * Thrown when any exception raises while reading map.
 * 
 * @author ramakrishnap
 */
public class InvalidMapException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidMapException(String message) {
		super(message);
	}
	
	public InvalidMapException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
