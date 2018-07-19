package com.pathfinder.exception;

/**
 * Thrown when no path found between current and target location.
 * 
 * @author ramakrishnap
 */
public class PathNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public PathNotFoundException(String message) {
		super(message);
	}
	
	public PathNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
