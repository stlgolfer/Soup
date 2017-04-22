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
		addToken('p');
		addToken(';');
		addToken(':');
		addToken('v');
		addToken('i');
		addToken('@');
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
	}
	
	public static void addToken(char token) {
		languageTokens.add(token);
	}
}