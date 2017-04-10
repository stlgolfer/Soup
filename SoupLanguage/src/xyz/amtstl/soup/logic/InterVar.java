package xyz.amtstl.soup.logic;

import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;

public class InterVar {
	public static String[] parseInternalVar(String[] numbers) throws NumberFormatException, SoupVariableException {
		IO.println("Hello from intervar");
		for (int f: LogicController.v.intVars) {
			IO.printInt(f);
		}
		for (int e = 0; e < numbers.length; e++) {
			if (numbers[e].charAt(0) == 'v') {
				numbers[e] = String.valueOf(LogicController.v.getVar(Integer.valueOf(numbers[e].charAt(2))));
			}
		}
		for (String f : numbers) {
			IO.println(f);
		}
		return numbers;
	}
}