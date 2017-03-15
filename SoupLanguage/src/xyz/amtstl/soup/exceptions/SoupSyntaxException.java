package xyz.amtstl.soup.exceptions;

public class SoupSyntaxException extends Exception {
	public SoupSyntaxException(char token, int pos, int line) {
		super("Unexpected Character: " + token + " at line " + String.valueOf(line) + " pos " + String.valueOf(pos));
	}
	
	public SoupSyntaxException(char token, int pos) {
		super("Unexpected Character: " + token + " at pos " + String.valueOf(pos));
	}
}