package xyz.amtstl.soup;

import java.util.ArrayList;
import java.util.List;

public class VariableHandler {
	private static List<Integer> intVars = new ArrayList<Integer>();
	
	public static void insertVar(int v, int point) {
		intVars.add(point, v);
	}
	
	public static int getVar(int i) {
		return intVars.get(i);
	}
}