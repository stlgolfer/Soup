package xyz.amtstl.soup.logic;

import java.util.List;

import xyz.amtstl.soup.exceptions.SoupSyntaxException;

public class Validator {
	
	/**
	 * Validates numbers to see if the parameters are valid
	 * @param arr List array of Strings to be validated from LogicController
	 * @throws SoupSyntaxException thrown when parameters are not valid
	 */
	public static void validateNumbers(List<String> arr) throws SoupSyntaxException {
		for (String f : arr) {
			try {
				Float.parseFloat(f);
			}
			catch (NumberFormatException ex) {
				throw new SoupSyntaxException();
			}
		}
	}
}