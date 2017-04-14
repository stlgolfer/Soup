package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;

import xyz.amtstl.soup.exceptions.SoupVariableException;

public class VariableHandler {
	protected static List<Integer> intVars = new ArrayList<Integer>();
	private static List<String> stringVars = new ArrayList<String>();
	
	public static void insertVar(int v, int point) {
		intVars.add(point, v);
	}
	
	public static int getVar(int i) throws SoupVariableException {
		try {
			return intVars.get(i);
		} catch (IndexOutOfBoundsException ex) {
			throw new SoupVariableException(i);
		}
	}
}