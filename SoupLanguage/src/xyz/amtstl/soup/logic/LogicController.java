package xyz.amtstl.soup.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import xyz.amtstl.soup.Parser;
import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;
import xyz.amtstl.soup.output.HTMLGen;

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
	public static Parser p;
	
	/**
	 * VariableHandler global var
	 */
	public static VariableHandler v;
	
	/**
	 * Main variable where the parsed data is
	 */
	public static List<String> ns;
	
	public static boolean ifState = false;
	
	/**
	 * Last result outputted by applicable functions. This gets used by the store function
	 */
	private static float lastResult = 0;
	
	/**
	 * Index cache for the main loop
	 */
	private static int index;
	
	/**
	 * Variable that locks the index
	 */
	private static boolean lockIndex = false;
	
	/**
	 * Constructor takes no args
	 */
	public LogicController() {
		p = new Parser();
		v = new VariableHandler();
		ns = new ArrayList<String>();
		VariableHandler.initiateVar();
	}
	
	/*
	 * MATH OPERATIONS AND CONTROLS
	 * 
	 */
	
	/**
	 * Adds numbers.
	 * Note that the comments are depreciated ways of crunching
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupAdd(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		/*numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]));
		lastResult = Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]);*/
		
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		float out = Float.parseFloat(ns.get(0));
		for (int e = 1; e < ns.size(); e++) {
			out += Float.parseFloat(ns.get(e));
		}
		
		lastResult = out;
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
		//IO.printFloat(Float.parseFloat(ns.get(0)) + Float.parseFloat(ns.get(1)));
		//lastResult = Float.parseFloat(ns.get(0)) + Float.parseFloat(ns.get(1));
	}
	
	/**
	 * Subtracts numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupSubtract(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		float out = Float.parseFloat(ns.get(0));
		for (int e = 1; e < ns.size(); e++) {
			out -= Float.parseFloat(ns.get(e));
		}
		
		lastResult = out;
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Multiplies numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupMultiply(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		float out = Float.parseFloat(ns.get(0));
		for (int e = 1; e < ns.size(); e++) {
			out *= Float.parseFloat(ns.get(e));
		}
		
		lastResult = out;
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Divides numbers
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupDivide(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		float out = Float.parseFloat(ns.get(0));
		for (int e = 1; e < ns.size(); e++) {
			out /= Float.parseFloat(ns.get(e));
		}
		
		lastResult = out;
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Raises numbers per exponent
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupPow(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		IO.printFloat((float)Math.pow(Float.parseFloat(ns.get(0)), Float.parseFloat(ns.get(1))));
		lastResult = (float)Math.pow(Float.parseFloat(ns.get(0)), Float.parseFloat(ns.get(1)));
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Logarithms
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupLog(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		double ex = Double.parseDouble(ns.get(0));
		/*double base = Double.parseDouble(ns.get(1));*/
		
		/*IO.println(String.valueOf((Math.log(ex)/(Math.log(base)))));*/
		lastResult = (float)(Math.log10(ex));
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Applies the Quadratic formula
	 * @deprecated
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupQuad(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
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
	 * @throws SoupSyntaxException 
	 */
	public void soupTrig(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		List<String> validation = new ArrayList<String>();
		for (int e = 1; e < ns.size(); e++) {
			validation.add(ns.get(e));
		}
		Validator.validateNumbers(validation);
		
		if (!lockIndex)
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
		case "arcs" : // arcsine
			lastResult = (float)(Math.asin(Double.parseDouble(ns.get(1))));
			IO.printFloat(lastResult);
			break;
		case "arcc" : // arccosine
			lastResult = (float)(Math.acos(Double.parseDouble(ns.get(1))));
			IO.printFloat(lastResult);
			break;
		case "arct" : // arctangent
			lastResult = (float)(Math.atan(Double.parseDouble(ns.get(1))));
			IO.printFloat(lastResult);
			break;
		default :
			throw new SoupSyntaxException(cache.charAt(i+2), i);
		}
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Finds the area per the parameters
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public void soupArea(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		List<String> validation = new ArrayList<String>();
		for (int e = 1; e < ns.size(); e++) {
			validation.add(ns.get(e));
		}
		Validator.validateNumbers(validation);
		
		if (!lockIndex)
		index = p.getIndex();
		
		String condition = ns.get(0);
		
		switch (condition) {
		case "s" : // square
			lastResult = Float.parseFloat(ns.get(1)) * Float.parseFloat(ns.get(2));
			IO.printFloat(lastResult);
			break;
		case "tri" : // traingle
			lastResult = Float.parseFloat(ns.get(1)) * Float.parseFloat(ns.get(2))/2;
			IO.printFloat(lastResult);
			break;
		case "tra" : // trapezoid
			lastResult = ((Float.parseFloat(ns.get(1)) + Float.parseFloat(ns.get(2))/2) * Float.parseFloat(ns.get(3)));
			IO.printFloat(lastResult);
			break;
		default :
			throw new SoupSyntaxException(cache.charAt(i+2), i);
		}
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Absolute values a number
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupAbs(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		lastResult = Math.abs(Float.parseFloat(ns.get(0)));
		IO.println(String.valueOf(lastResult));
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Rounds a number using Java math.round()
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupRound(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		lastResult = (float)Math.round(Float.valueOf(ns.get(0)));
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Square Roots a number
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupSquareRoot(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		lastResult = (float)Math.sqrt(Double.parseDouble(ns.get(0)));
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
	}
	
	/**
	 * Will spawn a random number in lastResult between the bounds
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public void soupRandomNum(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		Random rnd = new Random();
		lastResult = ThreadLocalRandom.current().nextInt(Integer.valueOf((int) Float.parseFloat(ns.get(0))), Integer.valueOf((int) Float.parseFloat(ns.get(1))));
		IO.printFloat(lastResult);
		HTMLGen.getTotalOutputs().add(lastResult);
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
	 * @throws SoupSyntaxException 
	 */
	public void soupPrint(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		if (!lockIndex)
		index = p.getIndex();
		
		List<String> validation = new ArrayList<String>();
		for (int e = 1; e < ns.size(); e++) {
			validation.add(ns.get(e));
		}
		Validator.validateNumbers(validation);
		
		switch (ns.get(1)) {
		case "0" :
			IO.print(ns.get(0));
			break;
		case "1" :
			IO.println(ns.get(0));
			break;
		}
	}
	
	/**
	 * Prints line to the user
	 * @deprecated
	 * @param i
	 * @param cache
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public void soupPrintLine(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		if (!lockIndex)
		index = p.getIndex();
		IO.println(ns.get(0));
	}
	
	/**
	 * Checks two numbers and prints whether they're true or false
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupIf(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
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
	 * This is the handler that marshals the the HTML generator
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public void soupHTMLHandler(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		if (!lockIndex)
		index = p.getIndex();
		try {
			HTMLGen.generateOutputDocumentation(ns.get(0), ns.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Extension of if function
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupIfDo(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parseInternalFunctions(i, cache);
		index = p.getIndex();
		
		/*boolean isStore = false;
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
		}*/
		
		String True = ns.get(0);
		String False = ns.get(1);
		lockIndex = true;
		
		if (ifState) {
			for (int e = 0; e < True.length(); e++) {
				Soup.checkToken(e, True, True.charAt(e));
			}
		}
		else {
			for (int e = 0; e < False.length(); e++) {
				Soup.checkToken(e, False, False.charAt(e));
			}
		}
		
		lockIndex = false;
		
		ifState = false;
		//isStore = false;
	}
	
	/**
	 * Retrieves a variable from VariableHandler
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupRetrieveVar(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
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
	 * @throws SoupSyntaxException 
	 */
	public void soupStoreVar(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		v.insertVar(lastResult, Integer.parseInt(ns.get(0)));
	}
	
	/**
	 * Stores the user input
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException 
	 */
	public void soupStoreUserIn(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		HTMLGen.getQuestionStrings().add(ns.get(0));
		List<String> validation = new ArrayList<String>();
		for (int e = 1; e < ns.size(); e++) {
			validation.add(ns.get(e));
		}
		Validator.validateNumbers(validation);
		
		if (!lockIndex)
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
	 * @throws SoupSyntaxException 
	 */
	public void soupStoreSingle(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		Validator.validateNumbers(ns);
		
		if (!lockIndex)
		index = p.getIndex();
		
		v.insertVar(Float.parseFloat(ns.get(0)), Integer.valueOf(ns.get(1)));
	}
	
	/**
	 * Executes a new for loop on main thread
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public void soupForLoop(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		
		/*List<String> validation = new ArrayList<String>();
		for (String f : ns) {
			validation.add(f);
		}
		validation.remove(validation.size() - 1);
		Validator.validateNumbers(validation);*/
		
		if (!lockIndex)
		index = p.getIndex() + 1;
		Looper.execNewForLoop((int)Integer.valueOf((int) Float.parseFloat(Soup.logic.ns.get(0))), (int)Integer.valueOf((int) Float.parseFloat(Soup.logic.ns.get(1))), cache, " ");
	}
	
	/**
	 * Does a while loop
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws SoupSyntaxException
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 */
	public void soupWhileLoop(int i, String cache) throws SoupSyntaxException, NumberFormatException, SoupVariableException {
		ns = p.parse(i, cache);
		
		if (!lockIndex)
		index = p.getIndex();
		
		Looper.execNewWhileLoop(cache);
	}
	
	/**
	 * Refreshes Numbers
	 * @deprecated
	 * @param i index to be passed to parser
	 * @param cache line of code from main loop
	 * @throws NumberFormatException
	 * @throws SoupVariableException
	 * @throws SoupSyntaxException
	 */
	public void soupRefreshNumbers(int i, String cache) throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		ns = p.parse(i, cache);
		//Validator.validateNumbers(ns);
		if (!lockIndex)
		index = p.getIndex();
	}
	
	public void soupBreakLoop() {
		Looper.isBreak = true;
		index += 1;
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
	public int getIndex() {
		return index;
	}
	
	/**
	 * Sets the current index
	 * @param newIndex the new index
	 */
	public void setIndex(int newIndex) {
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