package xyz.amtstl.soup.testing;

import org.junit.Assert;
import org.junit.Test;

import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;

public class TestSoupExceptions {
	@Test
	public void testSoupSyntaxException() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		try {
			Soup.parseFunc('f', 0, "f");
		}
		catch (SoupSyntaxException ex) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testSoupFunctionNotDeclaredException() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		try {
			Soup.parseFunc('F', 0, "F{0}");
		}
		catch (SoupFunctionNotDeclaredException ex) {
			Assert.assertTrue(true);
			System.out.println(ex.getMessage());
		}
	}
	
	/*
	 * Is this not needed anymore?
	 */
	/**
	 * @deprecated
	 */
	@Test
	public void testSoupVariableException() {
		try {
			Soup.parseFunc('V', 0, "V{0}");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}