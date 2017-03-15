package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;

public class LanguageController {
	private static List<Character> languageTokens;
	
	public LanguageController() {
		languageTokens = new ArrayList<Character>();
	}
	
	public static void addToken(char token) {
		languageTokens.add(token);
	}
}