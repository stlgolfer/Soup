package xyz.amtstl.soup.output;

import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;

public class FlagController {
	private static boolean printIndex = false;
	
	public static void passFlag(String flag) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		switch (flag) {
		case "-i" : // print index
			printIndex = true;
			break;
			default :
				break;
		}
	}
	
	public static boolean getPrintIndex() {
		return printIndex;
	}
	
	public static void execSoup(String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		for (int i = 0; i < cache.length(); i++) {
			if (cache.charAt(i) == ';') {
				Soup.checkToken(i, cache, cache.charAt(i));
				i = Soup.logic.getIndex();
			}
			else {
				Soup.checkToken(i, cache, cache.charAt(i));
			}
		}
	}
}