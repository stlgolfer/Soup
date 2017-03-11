package xyz.amtstl.soup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String args[]) throws IOException {
		//FileReader reader = new FileReader(System.getProperty("user.dir") + "/" + args[0].toString());
		FileReader reader = new FileReader("C:/users/amigala/desktop/soup/" + args[0].toLowerCase().toString());
		BufferedReader buff = new BufferedReader(reader);
		
		final String cache = buff.readLine();
		
		// Variables
		double a;
		double b;
		
		float stat1;
		float stat2;
		
		for (int i = 0; i < cache.length(); i++) {
			char c = cache.charAt(i);
			
			switch (c) {
			case '!' : // add two numbers
				//IO.println(String.valueOf((Integer.parseInt(String.valueOf(cache.charAt(i+1))) + Integer.parseInt(String.valueOf(cache.charAt(i+2))))));
				
				String whole = "";
				String n1 = "";
				String n2 = "";
				
				int index = 0;
				
				for (int e = i; e < cache.length(); e++) {
					if (cache.charAt(e) == '}'){
						index = e;
						break;
					}
					else if(cache.charAt(e) != '}') {
						whole+=cache.charAt(e);
					}
				}
				
				
				i = index;
				
				whole = whole.substring(2, whole.length());
				
				String[] numbers = whole.split("#");
				
				IO.printInt(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
				break;
			case '@' : // subtract two numbers
				IO.println(String.valueOf((Integer.parseInt(String.valueOf(cache.charAt(i+1))) - Integer.parseInt(String.valueOf(cache.charAt(i+2))))));
			case '#' : // multiply two numbers
				IO.println(String.valueOf((Integer.parseInt(String.valueOf(cache.charAt(i+1))) * Integer.parseInt(String.valueOf(cache.charAt(i+2))))));
				break;
			case '$' : // divide two numbers
				IO.println(String.valueOf((Float.parseFloat(String.valueOf(cache.charAt(i+1))) / Float.parseFloat(String.valueOf(cache.charAt(i+2))))));
				break;
			case '%' : // pow one number
				IO.println(String.valueOf(Math.pow((Integer.parseInt(String.valueOf(cache.charAt(i+1)))),Integer.parseInt(String.valueOf(cache.charAt(i+2))))));
				break;
			case '[' : // basic if statement
				stat1 = (float)Float.parseFloat(String.valueOf(cache.charAt(i+1)));
				stat2 = (float)Float.parseFloat(String.valueOf(cache.charAt(i+2)));
				if (stat1 == stat2)
					IO.println("True");
				else
					IO.println("False");
				break;
			}
		}
	}
}