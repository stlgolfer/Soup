package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;

public class LanguageDictionary {
	public static List<Character> languageTokens;
	
	public LanguageDictionary() {
		languageTokens = new ArrayList<Character>();
		
		addToken('+');
		addToken('-');
		addToken('*');
		addToken('%');
		addToken('^');
		addToken('#');
		addToken('A');
		addToken('[');
		addToken(';');
		addToken(':');
		addToken('I');
		addToken('$');
		addToken('|');
		addToken('?');
		addToken('&');
		addToken('~');
		addToken('R');
		addToken('H');
		addToken('/');
		addToken('[');
		addToken('.');
		addToken(' ');
		addToken('>');
		addToken('<');
		addToken('W');
		addToken('V');
		addToken('P');
		addToken('X');
		addToken('=');
		addToken('N');
	}
	
	public static void addToken(char token) {
		languageTokens.add(token);
	}
}