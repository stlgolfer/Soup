package xyz.amtstl.soup.logic;

import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;

public class Looper {
	private static int groundState = 0;
	
	/**
	 * Executes a new loop sequence
	 * @param minBound starting point
	 * @param maxBound loop will continue until
	 * @param cache line of code from program
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public static void execNewLoop(int minBound, int maxBound, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		groundState = Soup.logic.getIndex();
		for (int e = minBound; e < maxBound; e++) {
			for (int i = groundState; i < cache.length(); i++) {
				Soup.checkToken(i, cache, cache.charAt(i));
			}
		}
	}
}