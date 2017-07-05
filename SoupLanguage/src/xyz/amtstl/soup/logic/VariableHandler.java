package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;

import xyz.amtstl.soup.exceptions.SoupVariableException;

public class VariableHandler {
	/**
	 * List of integer variables
	 */
	protected static List<Float> intVars = new ArrayList<Float>();
	
	/**
	 * Inserts a variable into the list
	 * @param v
	 * @param point
	 */
	public void insertVar(float v, int point) {
		intVars.set(point, v);
	}
	
	public float getVar(int i) throws SoupVariableException {
		try {
			return intVars.get(i);
		} catch (IndexOutOfBoundsException ex) {
			throw new SoupVariableException(i);
		}
	}
	
	public List<Float> getVarStore() {
		return intVars;
	}
	
	public void initiateVar() {
		for (int i = 0; i <= 10000; i++) {
			intVars.add((float) 0);
		}
	}
}