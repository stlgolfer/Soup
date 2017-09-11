package xyz.amtstl.soup.interpolation;

import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;

public class FunctionInterpolator {
	
	/**
	 * Interprets a string as Soup
	 * @param s string to be interpreted
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 * @throws SoupFunctionNotDeclaredException 
	 */
	public static void interpolateString(String s) throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		for (int e = 0; e < s.length(); e++) {
			Soup.checkToken(e, s, s.charAt(e));
		}
	}
}