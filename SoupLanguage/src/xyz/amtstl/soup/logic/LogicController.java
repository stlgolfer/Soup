package xyz.amtstl.soup.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xyz.amtstl.soup.Parser;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;

/**
 * This is the main logic controller that handles all operations
 * and martials necessary controllers
 * @author Alexander C Migala
 *
 */
public class LogicController {
	/**
	 * Parser Variable
	 */
	private static Parser p;
	/**
	 * VariableHandler global var
	 */
	public static VariableHandler v;
	
	//private static String[] numbers;
	private static List<String> ns;
	public static boolean ifState = false;
	private static float lastResult = 0;
	
	private static int index;
	
	/**
	 * Constructor takes no args
	 */
	public LogicController() {
		p = new Parser();
		v = new VariableHandler();
		ns = new ArrayList<String>();
	}
	
	/*
	 * MATH OPERATIONS AND CONTROLS
	 * 
	 */
	
	/**
	 * Adds numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupAdd(int i, String cache) throws NumberFormatException, SoupVariableException {
		/*numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]));
		lastResult = Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]);*/
		
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		IO.printFloat(Float.parseFloat(ns.get(0)) + Float.parseFloat(ns.get(1)));
		lastResult = Float.parseFloat(ns.get(0)) + Float.parseFloat(ns.get(1));
	}
	
	/**
	 * Subtracts numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupSubtract(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		IO.printFloat(Float.parseFloat(ns.get(0)) - Float.parseFloat(ns.get(1)));
		lastResult = Float.parseFloat(ns.get(0)) - Float.parseFloat(ns.get(1));
	}
	
	/**
	 * Multiplies numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupMultiply(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		IO.printFloat(Float.parseFloat(ns.get(0)) * Float.parseFloat(ns.get(1)));
		lastResult = Float.parseFloat(ns.get(0)) * Float.parseFloat(ns.get(1));
	}
	
	/**
	 * Divides numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupDivide(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		IO.printFloat(Float.parseFloat(ns.get(0)) / Float.parseFloat(ns.get(1)));
		lastResult = Float.parseFloat(ns.get(0)) / Float.parseFloat(ns.get(1));
	}
	
	/**
	 * Raises numbers per exponent
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupPow(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		IO.printFloat((float)Math.pow(Float.parseFloat(ns.get(0)), Float.parseFloat(ns.get(1))));
		lastResult = (float)Math.pow(Float.parseFloat(ns.get(0)), Float.parseFloat(ns.get(1)));
	}
	
	/**
	 * Logarithms
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupLog(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		double ex = Double.parseDouble(ns.get(0));
		double base = Double.parseDouble(ns.get(1));
		
		IO.println(String.valueOf((Math.log(ex)/(Math.log(base)))));
		lastResult = (float)(Math.log(ex)/(Math.log(base)));
	}
	
	/**
	 * Applies the Quadratic formula
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupQuad(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		float a = Float.parseFloat(ns.get(0));
		float b = Float.parseFloat(ns.get(1));
		float c = Float.parseFloat(ns.get(2));
		
		//String[] varPoints = numbers[3].split("#");
		
		float pos = (float)((b*-1)+Math.sqrt((Math.pow(b, 2))-(4*a*c)));
		float neg = (float)((b*-1)+Math.sqrt((Math.pow(b, 2))+(4*a*c)));
		
		/*v.insertVar((int)pos, Integer.parseInt(varPoints[0]));
		v.insertVar((int)neg, Integer.parseInt(varPoints[1]));*/
		IO.println("X=" + String.valueOf(pos) + "\n" + "X=" + String.valueOf(neg));
	}
	
	/**
	 * Applies trigonometric functions
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupTrig(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		String condition = ns.get(0);
		
		/*
		 * Add the arc and inverse side of things
		 */
		switch (condition) {
		case "s" : // sine
			IO.printFloat(Float.valueOf((float)(Math.sin(Double.parseDouble(ns.get(1))))));
			lastResult = (float)(Math.sin(Double.parseDouble(ns.get(1))));
			break;
		case "c" : // cosine
			IO.printFloat(Float.valueOf((float)(Math.cos(Double.parseDouble(ns.get(1))))));
			lastResult = (float)(Math.cos(Double.parseDouble(ns.get(1))));
			break;
		case "t" : // tangent
			IO.printFloat(Float.valueOf((float)(Math.tan(Double.parseDouble(ns.get(1))))));
			lastResult = (float)(Math.tan(Double.parseDouble(ns.get(1))));
			break;
		}
	}
	
	/**
	 * Absolute values a number
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupAbs(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		lastResult = Math.abs(Float.parseFloat(ns.get(0)));
		IO.println(String.valueOf(lastResult));
	}
	
	/**
	 * Rounds a number using Java math.round()
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupRound(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		lastResult = (float)Math.round(Float.valueOf(ns.get(0)));
		IO.printFloat(lastResult);
	}
	
	/*public void soupSummation(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		for (int e = Integer.parseInt(ns.get(0)); e <= Integer.parseInt(ns.get(1)); e++) {
		}
	}*/
	
	/*
	 * FUNCTIONALITY CONTROLS
	 * 
	 */
	
	/**
	 * Prints some text per args
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupPrint(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		int mode = Integer.parseInt(ns.get(1));
		if (mode == 0) {
			IO.print(ns.get(0));
		}
		else {
			IO.println(ns.get(0));
		}
	}
	
	/**
	 * Checks two numbers and prints whether they're true or false
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupIf(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		//IO.println(numbers[0] + " " + numbers[1]);
				
		float n1 = Float.parseFloat(ns.get(0));
		float n2 = Float.parseFloat(ns.get(1));
		
		if (n1 == n2) {
			ifState = true;
			IO.println("True");
		}
		else {
			ifState = false;
			IO.println("False");
		}
	}
	
	/**
	 * Extension of if function
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupIfDo(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		boolean isStore = false;
		try {
			String makeorbreak = ns.get(2);
			isStore = true;
		}
		catch (Exception ex) {
			isStore = false;
		}
		
		if (ifState == true) {
			IO.println(String.valueOf(ns.get(0)));
			if (isStore)
			v.insertVar(Float.parseFloat(ns.get(0)), Integer.parseInt(ns.get(2)));
		}
		else {
			IO.println(String.valueOf(ns.get(1)));
			if (isStore)
			v.insertVar(Float.parseFloat(ns.get(1)), Integer.parseInt(ns.get(2)));
		}
		
		ifState = false;
		isStore = false;
	}
	
	/**
	 * Retrieves a variable from VariableHandler
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupRetrieveVar(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		float ret = v.getVar(Integer.parseInt(ns.get(0)));
		IO.printFloat(ret);
	}
	
	/**
	 * Stores a variable
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupStoreVar(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		v.insertVar(lastResult, Integer.parseInt(ns.get(0)));
	}
	
	/**
	 * Stores the user input
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupStoreUserIn(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		IO.println(ns.get(0));
		Scanner s = new Scanner(System.in);
		lastResult = s.nextFloat();
		
		v.insertVar(lastResult, Integer.parseInt(ns.get(1)));
	}
	
	/**
	 * Stores a single variable
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupStoreSingle(int i, String cache) throws NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		index = p.getIndex();
		
		v.insertVar(Float.parseFloat(ns.get(0)), Integer.valueOf(ns.get(1)));
	}
	
	/**
	 * Parses comments
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupComment(int i, String cache) throws NumberFormatException, SoupVariableException {
		index = cache.length();
	}
	
	/**
	 * Gets the current index
	 * @return the current index
	 */
	public static int getIndex() {
		return index;
	}
	
	/**
	 * Sets the current index
	 * @param newIndex the new index
	 */
	public static void setIndex(int newIndex) {
		p.setIndex(newIndex);
	}
	
	/**
	 * Gets the last result
	 * @return the last result variable
	 */
	public static float getLastResult() {
		return lastResult;
	}
}