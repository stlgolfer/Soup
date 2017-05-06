package xyz.amtstl.soup.testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String args[]) {
		Result r = JUnitCore.runClasses(TestLogicControllerSoup.class, TestLowLevel.class);
		
		for (Failure fail : r.getFailures()) {
			System.out.println(fail);
		}
		
		String resultFinal = String.valueOf(r.wasSuccessful());
		
		System.out.println("Soup ran without errors: " + resultFinal.toUpperCase());
	}
}