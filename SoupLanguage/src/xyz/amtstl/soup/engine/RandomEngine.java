package xyz.amtstl.soup.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEngine {
	private static List<Integer> numbers = new ArrayList<Integer>();
	private static Random rnd = new Random();
	
	public RandomEngine() {		
		updateNumbers(1500);
	}
	
	/**
	 * Gets a number from within a specific range
	 * @param min minimum number
	 * @param max maximum number
	 * @return
	 */
	public int getNumberRange(int min, int max) {
		if (min == max) {
			return max;
		}
		
		for (int e = 0; e < numbers.size(); e++) {
			if (numbers.get(e) < max && min < numbers.get(e)) {
				return numbers.get(e);
			}
		}
		return 0;
	}
	
	/**
	 * Gets the current Random instance
	 * @return the instance
	 */
	public Random getInstance() {
		return rnd;
	}
	
	/**
	 * Updates number collection
	 * @param count the maximum index value
	 */
	private static void updateNumbers(int count) {
		for (int f = 0; f <= count; f++) {
			int tempnum = rnd.nextInt(1000);
			
			numbers.add(tempnum);
		}
	}
	
	/**
	 * Prints the number collection to the user
	 */
	public void iterateNumberLibrary() {
		for (int e : numbers) {
			System.out.print(String.valueOf(e) + "\n");
		}
	}
	
	/**
	 * Gets the current number collection
	 * @return the number collection
	 */
	public List<Integer> getNumberSelection() {
		return numbers;
	}
}