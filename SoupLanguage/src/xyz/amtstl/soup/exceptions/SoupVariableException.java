package xyz.amtstl.soup.exceptions;

public class SoupVariableException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Exception is thrown when Soup tries to recall a variable that is non-existent
	 * @param var the memory point that was requested
	 */
	public SoupVariableException(int var) {
		super("Soup can not find variable: " + String.valueOf(var));
	}
}