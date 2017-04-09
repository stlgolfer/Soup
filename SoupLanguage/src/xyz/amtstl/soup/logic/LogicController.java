package xyz.amtstl.soup.logic;

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
	private static Parser p;
	private static VariableHandler v;
	
	private static String[] numbers;
	private static String single;
	public static boolean ifState = false;
	private static float lastResult = 0;
	public static int varCache = 0;
	
	private static int index;
	
	public LogicController() {
		p = new Parser();
		v = new VariableHandler();
	}
	
	/*
	 * MATH OPERATIONS AND CONTROLS
	 * 
	 */
	
	public static void soupAdd(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]));
		lastResult = Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]);
	}
	
	public static void soupSubtract(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) - Float.parseFloat(numbers[1]));
		lastResult = Float.parseFloat(numbers[0]) - Float.parseFloat(numbers[1]);
	}
	
	public static void soupMultiply(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) * Float.parseFloat(numbers[1]));
		lastResult = Float.parseFloat(numbers[0]) * Float.parseFloat(numbers[1]);
	}
	
	public static void soupDivide(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) / Float.parseFloat(numbers[1]));
		lastResult = Float.parseFloat(numbers[0]) / Float.parseFloat(numbers[1]);
	}
	
	public static void soupPow(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat((float)Math.pow(Float.parseFloat(numbers[0]), Float.parseFloat(numbers[1])));
		lastResult = (float)Math.pow(Float.parseFloat(numbers[0]), Float.parseFloat(numbers[1]));
	}
	
	public static void soupLog(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		double ex = Double.parseDouble(numbers[0]);
		double base = Double.parseDouble(numbers[1]);
		
		IO.println(String.valueOf((Math.log(ex)/(Math.log(base)))));
		lastResult = (float)(Math.log(ex)/(Math.log(base)));
	}
	
	public static void soupQuad(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		float a = Float.parseFloat(numbers[0]);
		float b = Float.parseFloat(numbers[1]);
		float c = Float.parseFloat(numbers[2]);
		
		//String[] varPoints = numbers[3].split("#");
		
		float pos = (float)((b*-1)+Math.sqrt((Math.pow(b, 2))-(4*a*c)));
		float neg = (float)((b*-1)+Math.sqrt((Math.pow(b, 2))+(4*a*c)));
		
		/*v.insertVar((int)pos, Integer.parseInt(varPoints[0]));
		v.insertVar((int)neg, Integer.parseInt(varPoints[1]));*/
		IO.println("X=" + String.valueOf(pos) + "\n" + "X=" + String.valueOf(neg));
	}
	
	/*
	 * FUNCTIONALITY CONTROLS
	 * 
	 */
	public static void soupPrint(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		int mode = Integer.parseInt(numbers[1]);
		if (mode == 0) {
			IO.print(numbers[0]);
		}
		else {
			IO.println(numbers[0]);
		}
	}
	
	public static void soupIf(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		//IO.println(numbers[0] + " " + numbers[1]);
				
		float n1 = Float.parseFloat(numbers[0]);
		float n2 = Float.parseFloat(numbers[1]);
		
		if (n1 == n2) {
			ifState = true;
			IO.println("True");
		}
		else {
			ifState = false;
			IO.println("False");
		}
	}
	
	public static void soupIfDo(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		boolean isStore = false;
		try {
			String makeorbreak = numbers[2];
			isStore = true;
		}
		catch (Exception ex) {
			isStore = false;
		}
		
		if (ifState == true) {
			IO.println(String.valueOf(numbers[0]));
			if (isStore)
			v.insertVar(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[2]));
		}
		else {
			IO.println(String.valueOf(numbers[1]));
			if (isStore)
			v.insertVar(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]));
		}
		
		ifState = false;
		isStore = false;
	}
	
	public static void soupRetrieveVar(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		int ret = v.getVar(Integer.parseInt(numbers[0]));
		IO.printInt(ret);
		varCache = ret;
	}
	
	public static void soupStoreVar(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		v.insertVar((int)lastResult, Integer.parseInt(numbers[0]));
	}
	
	public static void soupStoreUserIn(int i, String cache) throws NumberFormatException, SoupVariableException {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		IO.println(numbers[0]);
		Scanner s = new Scanner(System.in);
		lastResult = (int)s.nextInt();
		s.close();
		
		v.insertVar((int)lastResult, Integer.parseInt(numbers[1]));
	}
	
	public static int getIndex() {
		return index;
	}
	
	public static void setIndex(int newIndex) {
		p.setIndex(newIndex);
	}
	
	public static float getLastResult() {
		return lastResult;
	}
}