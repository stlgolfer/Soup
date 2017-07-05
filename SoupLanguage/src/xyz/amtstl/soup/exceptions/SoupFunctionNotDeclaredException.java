package xyz.amtstl.soup.exceptions;

public class SoupFunctionNotDeclaredException extends Exception {
	private static final long serialVersionUID = 1L;

	public SoupFunctionNotDeclaredException (int point ) {
		super("No function declared at point " + String.valueOf(point));
	}
}