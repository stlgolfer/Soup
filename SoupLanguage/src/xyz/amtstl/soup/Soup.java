package xyz.amtstl.soup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.logic.LanguageController;
import xyz.amtstl.soup.logic.LogicController;
import xyz.amtstl.soup.misc.IO;

public class Soup {
	/*private static String[] numbers;
	private static String single;*/
	private static int lineNumber = 1;
	static LogicController logic = new LogicController();
	//static int indexCache = 0;
	
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws Exception {
		//FileReader reader = new FileReader(System.getProperty("user.dir") + "/" + args[0].toString());
		FileReader reader = new FileReader("C:/users/alex/desktop/github/soup/Files/program.soup");
		//FileReader reader = new FileReader("C:/Users/amigala/Desktop/Github/Soup/Files/program.soup");
		BufferedReader buff = new BufferedReader(reader);
		
		while (true) {		
			final String cache = buff.readLine();
			
			try {
				for (int i = 0; i < cache.length(); i++) {
					char c = cache.charAt(i);
					parseFunc(c, i, cache);
					i = logic.getIndex();
					
				}
			} catch (NullPointerException ex) {
				System.exit(0);
			}
		
			lineNumber++;
			logic.setIndex(0);
		}
	}
	
	public static void parseFunc(char c, int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		switch (c) {
			case '!' : // add two numbers
				logic.soupAdd(i, cache);
				break;
		case '@' : // subtract two numbers
			logic.soupSubtract(i, cache);
			break;
		case '#' : // multiply two numbers
			logic.soupMultiply(i, cache);			
			break;
		case '$' : // divide two numbers
			logic.soupDivide(i, cache);			
			break;
		case '%' : // pow one number
			logic.soupPow(i, cache);			
			break;
		case '^' : // basic logarithm
			logic.soupLog(i, cache);			
			break;
		case '[' : // basic if statement
			logic.soupIf(i, cache);
			break;
		case '&' :
			logic.soupPrint(i, cache);
			break;
		case 'v': // gets a variable
			logic.soupRetrieveVar(i, cache);
			break;
		case '.' :
			break;
		default :
			throw new SoupSyntaxException(cache.charAt(i), i, lineNumber);
		}
	}
}