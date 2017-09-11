package xyz.amtstl.soup.output;

import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.logic.LogicController;

public class FlagController {
	public static boolean printIndex = false;
	
	public static void passFlag(String flag) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		switch (flag) {
		case "-i" : // print index
			printIndex = true;
			break;
		default :
			break;
		}
	}
	
	public static void execSoup(String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		for (int i = 0; i < cache.length(); i++) {
			if (cache.charAt(i) == ';') {
				Soup.checkToken(i, cache, cache.charAt(i));
				i = LogicController.index;
			}
			else {
				Soup.checkToken(i, cache, cache.charAt(i));
			}
		}
	}
}