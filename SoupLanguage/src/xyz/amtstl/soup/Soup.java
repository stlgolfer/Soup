package xyz.amtstl.soup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.misc.HTTPHandler;
import xyz.amtstl.soup.misc.IO;

public class Soup {
	private static String[] numbers;
	private static String single;
	
	public static void main(String args[]) throws Exception {
		//FileReader reader = new FileReader(System.getProperty("user.dir") + "/" + args[0].toString());
		FileReader reader = new FileReader("C:/users/alex/desktop/github/soup/Files/" + args[0].toLowerCase().toString());
		BufferedReader buff = new BufferedReader(reader);
		
		final String cache = buff.readLine();
		
		for (int i = 0; i < cache.length(); i++) {
			char c = cache.charAt(i);
			
			switch (c) {
			case '!' : // add two numbers				
				numbers = Parser.parseNumbers(i, cache);
				i = Parser.getIndex();
				
				IO.printFloat(Float.parseFloat(numbers[0]) + Float.parseFloat(numbers[1]));
				break;
			case '@' : // subtract two numbers
				numbers = Parser.parseNumbers(i, cache);
				i = Parser.getIndex();
				
				IO.printFloat(Float.parseFloat(numbers[0]) - Float.parseFloat(numbers[1]));
				break;
				
			case '#' : // multiply two numbers				
				numbers = Parser.parseNumbers(i, cache);
				i = Parser.getIndex();
				
				IO.printFloat(Float.parseFloat(numbers[0]) * Float.parseFloat(numbers[1]));
				break;
			case '$' : // divide two numbers
				numbers = Parser.parseNumbers(i, cache);
				i = Parser.getIndex();
				
				IO.printFloat(Float.parseFloat(numbers[0]) / Float.parseFloat(numbers[1]));
				break;
			case '%' : // pow one number
				numbers = Parser.parseNumbers(i, cache);
				i = Parser.getIndex();
				
				IO.printFloat((float)Math.pow(Float.parseFloat(numbers[0]), Float.parseFloat(numbers[1])));
				break;
			case 'G' :
				single = Parser.parseSingle(i, cache);
				i = Parser.getIndex();
				
				IO.println(HTTPHandler.sendGet(single));
				break;
			case '[' : // basic if statement
				
				numbers = Parser.parseNumbers(i, cache);
				i = Parser.getIndex();
				
				if (numbers[0] == numbers[1])
					IO.println("True");
				else
					IO.println("False");
				break;
			case '.' :
				break;
			default :
				throw new SoupSyntaxException(cache.charAt(i), i);
			}
		}
	}
}