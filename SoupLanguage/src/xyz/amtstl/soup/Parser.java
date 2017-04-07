package xyz.amtstl.soup;

public class Parser {
	private static int inx;
	
	public static String[] parseNumbers(int i, String cache) {
		String whole = "";
		
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
		
		
		inx = index;
		
		whole = whole.substring(2, whole.length());
		
		String[] numbers = whole.split(",");
		return numbers;
	}
	
	public static String parseSingle(int i, String cache) {
		String whole = "";
		
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
		
		
		inx = index;
		
		whole = whole.substring(2, whole.length());
		
		return whole;
	}
	
	public static int getIndex() {
		return inx;
	}
	
	public static void setIndex(int newIndex) {
		inx = newIndex;
	}
}