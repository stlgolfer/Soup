package xyz.amtstl.soup;

import java.io.BufferedReader;
import java.io.FileReader;
import xyz.amtstl.soup.engine.RandomEngine;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.logic.LanguageDictionary;
import xyz.amtstl.soup.logic.LogicController;
import xyz.amtstl.soup.logic.Suppressor;
import xyz.amtstl.soup.misc.IO;
import xyz.amtstl.soup.output.FlagController;

public class Soup {
	public static int lineNumber = 1;
	private static boolean isOneLine = false;
	
	// controllers
	private static LogicController logic = new LogicController();
	static LanguageDictionary lang = new LanguageDictionary();
	
	/**
	 * Main thread marshal
	 * @param args args from user
	 * @throws Exception for forced exit
	 */
	public static void main(String args[]) throws Exception {		
		FileReader reader = null;
		BufferedReader buff = null;
		
		if (args[0].contains(".soup")) {
		
			try {
				//reader = new FileReader(System.getProperty("user.dir") + "/" + args[0].toString());
				reader = new FileReader("C:/users/alex/desktop/github/soup/Files/program.soup");
				//reader = new FileReader("C:/Users/amigala/Desktop/Github/Soup/Files/program.soup");
				//reader = new FileReader("C:/Users/Alex/Desktop/Github/Soup/Files/program.soup");
			
				// pass flag
				try {
					FlagController.passFlag(args[1].toString().toLowerCase());
				}
				catch (Exception e) {
				
				}
			}
			catch (Exception ex) {
				IO.println("File not found! Are you sure it is in this folder?");
				System.exit(0);
			}
			buff = new BufferedReader(reader);
			}
			else {
				FlagController.execSoup(args[0]);
			
				isOneLine = true;
			
				try {
					FlagController.passFlag(args[1].toString().toLowerCase());
				}
				catch (Exception e) {
				
				}
			}
		
		/*
		 * ALWAYS USE BREAKS WHEN ADDING NEW TOKENS AND FUNCTIONS
		 * 
		 */
		while (true && isOneLine == false) {
			final String cache = buff.readLine();
			
			try {
				for (int i = 0; i < cache.length(); i++) {
					char c = cache.charAt(i);
					switch (c) {
					case '+' : // add two numbers
						logic.soupAdd(i, cache);
						i = logic.getIndex();
						break;
					case '_' : // subtract two numbers
						logic.soupSubtract(i, cache);
						i = logic.getIndex();
						break;
					case '*' : // multiply two numbers
						logic.soupMultiply(i, cache);
						i = logic.getIndex();
						break;
					case '%' : // divide two numbers
						logic.soupDivide(i, cache);		
						i = logic.getIndex();
						break;
					case '^' : // pow one number
						logic.soupPow(i, cache);
						i = logic.getIndex();
						break;
					case '#' : // base 10 logarithm
						logic.soupLog(i, cache);
						i = logic.getIndex();
						break;
					case '@' : // break soup
						IO.println("Soup exiting with code 2 (requested per program)");
						System.exit(0);
						break;
					case 'A' : // area
						logic.soupArea(i, cache);
						i = logic.getIndex();
						break;
					case '=' : // basic if statement
						logic.soupIf(i, cache);
						i = logic.getIndex();
						break;
					case 'P' : // print line
						logic.soupPrint(i, cache);
						i = logic.getIndex();
						break;						
					case ';' : // extension of if
						logic.soupIfDo(i, cache);
						i = logic.getIndex();
						break;
					case ':' : // stores last result
						logic.soupStoreVar(i, cache);
						i = logic.getIndex();
						break;
					case 'V': // gets a variable
						logic.soupRetrieveVar(i, cache);
						i = logic.getIndex();
						break;
					case 'I': // gets var from user and stores it
						logic.soupStoreUserIn(i, cache);
						i = logic.getIndex();
						break;
					case '$' : // trigonometric functions
						logic.soupTrig(i, cache);
						i = logic.getIndex();
						break;
					case '|' : // absolute value
						logic.soupAbs(i, cache);
						i = logic.getIndex();
						break;
					case '?' : // round number to int
						logic.soupRound(i, cache);
						i = logic.getIndex();
						break;
					case '&' : // square root
						logic.soupSquareRoot(i, cache);
						i = logic.getIndex();
						break;
					case 'R' : // random number generator
						logic.soupRandomNum(i, cache);
						i = logic.getIndex();
						break;
					case 'H' : // html generator
						logic.soupHTMLHandler(i, cache);
						i = logic.getIndex();
						break;
					case '~': // stores a single variable
						logic.soupStoreSingle(i, cache);
						i = logic.getIndex();
						break;
					case '/': // comments
						logic.soupComment(i, cache);
						i = logic.getIndex();
						break;
					case '[' : // loop
						logic.soupForLoop(i, cache);
						i = logic.getIndex();
						break;
					case ']' :
						break;
					case 'W' : // while loop
						logic.soupWhileLoop(i, cache);
						i = logic.getIndex();
						break;
					case '<' : // less than if
						logic.soupIfLessThan(i, cache);
						i = logic.getIndex();
						break;
					case '>' : // gretaer than if
						logic.soupIfGreaterThan(i, cache);
						i = logic.getIndex();
						break;
					case 'X' : // breaks loop
						logic.soupBreakLoop();
						i = logic.getIndex();
						break;
					case 'N' : // while not
						logic.soupWhileNotLoop(i, cache);
						i = logic.getIndex();
						break;
					case 'S' : // store a function
						logic.soupStoreFunction(i, cache);
						i  = logic.getIndex();
						break;
					case 'F' :
						logic.soupGetFunction(i, cache);
						i = logic.getIndex();
						break;
					case '.' : // like a semicolon
						break;
					case ' ': // space nullifier
						break;
					case ')' :
						break;
					case '-' :
						break;
					default :
						throw new SoupSyntaxException(cache.charAt(i), i+1, lineNumber);
					}
					
					if (FlagController.getPrintIndex()) {
						IO.println("Current Index: " + String.valueOf(i));
					}
				}
			} catch (NullPointerException ex) {
				System.exit(0);
			}
			lineNumber++;
			logic.setIndex(0);
		}
	}
	
	/**
	 * Did the corresponding function per character
	 * @param c
	 * @param i
	 * @param cache
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 * @throws SoupFunctionNotDeclaredException 
	 */
	public static void parseFunc(char c, int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		switch (c) {
		case '+' : // add two numbers
			logic.soupAdd(i, cache);
			break;
		case '_' : // subtract two numbers
			logic.soupSubtract(i, cache);
			break;
		case '@' : // break soup
			IO.println("Soup exiting with code 2 (requested per program)");
			System.exit(0);
			break;
		case '*' : // multiply two numbers
			logic.soupMultiply(i, cache);
			break;
		case '%' : // divide two numbers
			logic.soupDivide(i, cache);		
			break;
		case '^' : // pow one number
			logic.soupPow(i, cache);	
			break;
		case '#' : // basic logarithm
			logic.soupLog(i, cache);	
			break;
		case 'A' : // area
			logic.soupArea(i, cache);
			break;
		case '=' : // basic if statement
			logic.soupIf(i, cache);
			break;
		case ';' : // extension of if
			logic.soupIfDo(i, cache);
			break;
		case ':' : // stores last result
			logic.soupStoreVar(i, cache);
			break;
		case 'V': // gets a variable
			logic.soupRetrieveVar(i, cache);
			break;
		case 'I': // gets var from user and stores it
			logic.soupStoreUserIn(i, cache);
			break;
		case '$' : // trig
			logic.soupTrig(i, cache);
			break;
		case '|' : // absolute value
			logic.soupAbs(i, cache);
			break;
		case '?' : // round number to int
			logic.soupRound(i, cache);
			break;
		case '&' : // square root
			logic.soupSquareRoot(i, cache);
			break;
		case 'R' : // random number generator
			logic.soupRandomNum(i, cache);
			break;
		case 'H' : // html generator
			logic.soupHTMLHandler(i, cache);
			break;
		case '~': // stores a single variable
			logic.soupStoreSingle(i, cache);
			break;
		case '/': // comments
			logic.soupComment(i, cache);
			break;
		case '[' : // loop
			logic.soupForLoop(i, cache);
			break;
		case '.' : // like a semicolon
			break;
		case ']' :
			break;
		case ' ': // space nullifier
			break;
		case 'P':
			logic.soupPrint(i, cache);
			break;
		case '<' : // less than if
			logic.soupIfLessThan(i, cache);
			break;
		case '>' : // gretaer than if
			logic.soupIfGreaterThan(i, cache);
			break;
		case 'W' :
			logic.soupWhileLoop(i, cache);
			break;
		case 'N' : // while not
			logic.soupWhileNotLoop(i, cache);
			break;
		case 'X' : // breaks loop
			logic.soupBreakLoop();
			break;
		case ')' :
			break;
		case '-' :
			break;
		case 'S' : // store a function
			logic.soupStoreFunction(i, cache);
			break;
		case 'F' :
			logic.soupGetFunction(i, cache);
			break;
		default :
			throw new SoupSyntaxException(cache.charAt(i), i+1, lineNumber);
		}
	}
	
	/**
	 * Checks tokens
	 * @param i
	 * @param cache
	 * @param c
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 * @throws SoupFunctionNotDeclaredException 
	 */
	public static void checkToken(int i, String cache, char c) throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		for (int e = 0; e < lang.languageTokens.size(); e++) {
			if (cache.charAt(i) == lang.languageTokens.get(e)) {
				parseFunc(c, i, cache);
				//indexCache = logic.getIndex();
			}
		}
	}
	
	public static void checkToken(int i, String cache, char c, Suppressor s) throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		for (int e = 0; e < lang.languageTokens.size(); e++) {
			if (cache.charAt(i) == lang.languageTokens.get(e)) {
				if (!s.isSuppressed()) {
					parseFunc(c, i, cache);
				}
				else if (s.isSuppressed() && i != s.getContinueIndex()) {
					// do nothing
				}
				else if (s.isSuppressed() && i == s.getContinueIndex()) {
					s.setSuppression(false);
					parseFunc(c, i, cache);
				}
			}
		}
	}
	
	public static LogicController getMainLogic() {
		return logic;
	}
}