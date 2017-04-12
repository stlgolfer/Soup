package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;

import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;

public class InterVar {
	public static String[] parseInternalVar(String[] numbers, int[] intArr) throws NumberFormatException, SoupVariableException {
		IO.println("Hello from intervar");
		String[] n = numbers;
		List<Integer> ints = new ArrayList<Integer>();
		
		for (String f : n) {
			if (f.charAt(0) == 'v') {
				int retIndex = Integer.parseInt(f.substring(2, f.length()));
				f = String.valueOf(LogicController.v.getVar(retIndex));
				IO.println("Number Retrieved from InterVar: " + f);
				ints.add(Integer.valueOf(f));
			}
		}
		
		for (int i = 0; i < ints.size(); i++) {
			n[i] = String.valueOf(ints.get(i));
		}
		return n;
	}
}