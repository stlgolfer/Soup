package xyz.amtstl.soup.exceptions;

public class SoupVariableException extends Exception {
	public SoupVariableException(int var) {
		super("Soup cannot find variable: " + String.valueOf(var));
	}
}