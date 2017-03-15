package xyz.amtstl.soup.logic;

import xyz.amtstl.soup.Parser;
import xyz.amtstl.soup.VariableHandler;
import xyz.amtstl.soup.misc.IO;

public class LogicController {
	private static Parser p;
	private static String[] numbers;
	private static String single;
	
	private static int index;
	
	public LogicController() {
		p = new Parser();
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
	
	public static void soupIf(int i, String cache) {
		numbers = p.parseNumbers(i, cache);
		index = p.getIndex();
		
		IO.println(numbers[0] + " " + numbers[1]);
		
		float n1 = Float.parseFloat(numbers[0]);
		float n2 = Float.parseFloat(numbers[1]);
		
		if (n1 == n2)
			IO.println("True");
		else
			IO.println("False");
	}
	
	public static void soupRetrieveVar(int i, String cache) {
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