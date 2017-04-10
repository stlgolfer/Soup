package xyz.amtstl.soup;

import xyz.amtstl.soup.exceptions.SoupVariableException;
//import xyz.amtstl.soup.logic.InterVar;
import xyz.amtstl.soup.misc.IO;

public class Parser {
	private static int inx;
	//private static InterVar inter = new InterVar();
	
	public static String[] parseNumbers(int i, String cache) throws NumberFormatException, SoupVariableException {
		String whole = "";
		
		int index = 0;
		
		for (int e = i; e < cache.length(); e++) {
			if (cache.charAt(e) == '}'){
				index = e;
				break;
			}
			else if(cache.charAt(e) != '}') {
				whole+=cache.charAt(e);
			}
		}
		
		inx = index;
		
		whole = whole.substring(2, whole.length());
		
		String[] numbers = whole.split(",");
		
		return numbers;
	}
	
	public static String parseSingle(int i, String cache) {
		String whole = "";
		
		int index = 0;
		
		for (int e = i; e < cache.length(); e++) {
			if (cache.charAt(e) == '}'){
				index = e;
				break;
			}
			else if(cache.charAt(e) != '}') {
				whole+=cache.charAt(e);
			}
		}
		
		
		inx = index;
		IO.println(String.valueOf(whole.charAt(2)));
		whole = whole.substring(2, whole.length());
		return whole;
	}
	
	public static int getIndex() {
		return inx;
	}
	
	public static void setIndex(int newIndex) {
		inx = newIndex;
	}
}