package xyz.amtstl.soup.exceptions;

public class SoupVariableException extends Exception {
	public SoupVariableException(int var) {
		super("Soup can not find variable: " + String.valueOf(var));
	}
}