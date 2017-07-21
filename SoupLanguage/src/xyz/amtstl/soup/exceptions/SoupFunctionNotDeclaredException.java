package xyz.amtstl.soup.exceptions;

public class SoupFunctionNotDeclaredException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Exception thrown when Soup tries to make a call to a function that is non-existent
	 * @param point the memory slot for the requested function
	 */
	public SoupFunctionNotDeclaredException (int point) {
		super("No function declared at point " + String.valueOf(point));
	}
}