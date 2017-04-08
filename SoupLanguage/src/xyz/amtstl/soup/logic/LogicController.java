package xyz.amtstl.soup.logic;

import xyz.amtstl.soup.Parser;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;

public class LogicController {
	private static Parser p;
	private static VariableHandler v;
	
	private static String[] numbers;
	private static String single;
	public static boolean ifState = false;
	
	private static int index;
	
	public LogicController() {
		p = new Parser();
		v = new VariableHandler();
	}
	
	public static void soupAdd(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]));
	}
	
	public static void soupSubtract(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) - Float.parseFloat(numbers[1]));
	}
	
	public static void soupMultiply(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) * Float.parseFloat(numbers[1]));
	}
	
	public static void soupDivide(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat(Float.parseFloat(numbers[0]) / Float.parseFloat(numbers[1]));
	}
	
	public static void soupPow(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		IO.printFloat((float)Math.pow(Float.parseFloat(numbers[0]), Float.parseFloat(numbers[1])));
	}
	
	public static void soupLog(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		double ex = Double.parseDouble(numbers[0]);
		double base = Double.parseDouble(numbers[1]);
		
		IO.println(String.valueOf((Math.log(ex)/(Math.log(base)))));
	}
	
	public static void soupPrint(int i, String cache) {
		single = p.parseSingle(i, cache);
		index = p.getIndex();
		
		IO.println(single);
	}
	
	public static void soupIf(int i, String cache) {
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
	
	/*private static boolean checkIfAvail(int i, String cache) {
		try {
			if (cache.charAt(i+1) == ':') {
				return true;
			}
		}
		catch (Exception ex) {
			return false;
		}
		return false;
	}*/
	
	public static void soupIfDo(int i, String cache) {
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
		String v = p.parseSingle(i, cache);
		index = p.getIndex();
		int ret = VariableHandler.getVar(Integer.parseInt(v));
		IO.printInt(ret);
	}
	
	public static int getIndex() {
		return index;
	}
	
	public static void setIndex(int newIndex) {
		p.setIndex(newIndex);
	}
}