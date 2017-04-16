package xyz.amtstl.soup.exceptions;

import xyz.amtstl.soup.Soup;

public class SoupSyntaxException extends Exception {
	
	/**
	 * Thrown when there is an issue with parameters
	 */
	public SoupSyntaxException() {
		super("Parameters are not numbers at line " + String.valueOf(Soup.lineNumber));
	}
	
	/**
	 * Thrown when there is a function identification error
	 * @param token token that is unidentified
	 * @param pos position where is the issue is
	 * @param line line number of where the issue is
	 */
	public SoupSyntaxException(char token, int pos, int line) {
		super("Unexpected Character: " + token + " at line " + String.valueOf(line) + " pos " + String.valueOf(pos));
	}
	
	/**
	 * Thrown when there is a function identification error
	 * @param token token that is unidentified
	 * @param pos position where is the issue is
	 */
	public SoupSyntaxException(char token, int pos) {
		super("Unexpected Character: " + token + " at pos " + String.valueOf(pos));
	}
}