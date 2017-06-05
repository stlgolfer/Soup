package xyz.amtstl.soup.exceptions;

public class SoupVariableException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SoupVariableException(int var) {
		super("Soup can not find variable: " + String.valueOf(var));
	}
}