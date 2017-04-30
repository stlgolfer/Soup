package xyz.amtstl.soup.output;

public class FlagController {
	private static boolean printIndex = false;
	
	public static void passFlag(String flag) {
		switch (flag) {
		case "-i" : // print index
			printIndex = true;
			break;
		}
	}
	
	public static boolean getPrintIndex() {
		return printIndex;
	}
}