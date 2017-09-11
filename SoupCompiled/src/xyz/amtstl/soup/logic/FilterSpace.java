package xyz.amtstl.soup.logic;

public class FilterSpace {
	public static String rejectSpaces(String input) {
		String out = "";
		
		for (int e = 0; e < input.length(); e++) {
			if (input.charAt(e) != ' ') {
				out += String.valueOf(input.charAt(e));
			}
		}
		
		return out;
	}
}