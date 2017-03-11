package xyz.amtstl.soup.exceptions;

public class SoupSyntaxException extends Exception {
	public SoupSyntaxException(char token, int pos) {
		super("Unexpected Character: " + token + " at position " + String.valueOf(pos));
	}
}