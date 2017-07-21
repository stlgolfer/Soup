package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;

import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;

public class InterVar {
	private static List<String> temp = new ArrayList<String>();
	
	public static void parseInternalVar(String[] numbers) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		temp = new ArrayList<String>();
		
		/* Parse the v function */
		for (String e : numbers) {
			if (e.charAt(0) == 'v') {
				try {
					int indexReq = Integer.parseInt(e.substring(1));
					temp.add(String.valueOf(VariableHandler.getVar(indexReq)));
				}
				catch (NumberFormatException ex) {
					throw new SoupSyntaxException();
				}
				catch (StringIndexOutOfBoundsException ex) {
					throw new SoupSyntaxException();
				}
			}
			else {
				temp.add(e);
			}
		}
	}
	
	public static List<String> getParsedNumbers() {
		return temp;
	}
}