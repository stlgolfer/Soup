package xyz.amtstl.soup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.logic.LanguageController;
import xyz.amtstl.soup.logic.LogicController;
import xyz.amtstl.soup.misc.IO;

public class Soup {
	private static String[] numbers;
	private static String single;
	private static int lineNumber = 1;
	
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws Exception {
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/" + args[0].toString());
		//FileReader reader = new FileReader("C:/users/alex/desktop/github/soup/Files/" + args[0].toLowerCase().toString());
		//FileReader reader = new FileReader("C:/Users/amigala/Desktop/Github/Soup/Files/" + args[0].toLowerCase().toString());
		BufferedReader buff = new BufferedReader(reader);
		
		// controllers
		LogicController logic = new LogicController();
		
		while (true) {		
			final String cache = buff.readLine();
		
			try {
				for (int i = 0; i < cache.length(); i++) {
					char c = cache.charAt(i);
			
					switch (c) {
						case '!' : // add two numbers
							logic.soupAdd(i, cache);
							i = logic.getIndex();
							break;
						case '@' : // subtract two numbers
							logic.soupSubtract(i, cache);
							i = logic.getIndex();
							break;
				
						case '#' : // multiply two numbers
							logic.soupMultiply(i, cache);
							i = logic.getIndex();
							break;
						case '$' : // divide two numbers
							logic.soupDivide(i, cache);
							i = logic.getIndex();
							break;
						case '%' : // pow one number
							logic.soupPow(i, cache);
							i = logic.getIndex();
							break;
						case '^' : // basic logarithm
							logic.soupLog(i, cache);
							i = logic.getIndex();
							break;
						case '[' : // basic if statement
							logic.soupIf(i, cache);
							i = logic.getIndex();
							break;
						case 'v': // gets a variable
							logic.soupRetrieveVar(i, cache);
							i = logic.getIndex();
							break;
						case '.' :
							break;
						default :
							throw new SoupSyntaxException(cache.charAt(i), i, lineNumber);
					}
				}
		} catch (NullPointerException ex) {
			System.exit(0);
		}
		
			lineNumber++;
			logic.setIndex(0);
		}
	}
}