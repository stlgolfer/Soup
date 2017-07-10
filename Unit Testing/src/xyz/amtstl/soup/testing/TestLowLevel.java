package xyz.amtstl.soup.testing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import xyz.amtstl.soup.Parser;
import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.interpolation.FunctionInterpolator;
import xyz.amtstl.soup.logic.Validator;
import xyz.amtstl.soup.logic.InterVar;
import xyz.amtstl.soup.logic.Validator;

public class TestLowLevel {
	private static Soup soup = new Soup();
	
	@Test
	public void testBasicParser() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupAdd(0, "+{4.6,7,1}");
		
		Assert.assertEquals(4.6, Float.parseFloat(soup.getMainLogic().ns.get(0)), 0.1);
		Assert.assertEquals(7.0, Float.parseFloat(soup.getMainLogic().ns.get(1)), 0.1);
		Assert.assertEquals(1.0, Float.parseFloat(soup.getMainLogic().ns.get(2)), 0.1);
	}
	
	@Test
	public void testFunctionInterpolation() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		FunctionInterpolator.interpolateString("+{5,5.7}");
		
		System.out.println(soup.getMainLogic().getLastResult());
		Assert.assertEquals(10.7, soup.getMainLogic().getLastResult(), 0.1);
	}
	
	@Test(expected=SoupSyntaxException.class)
	public void testValidator() throws SoupSyntaxException {
		List<String> validation = new ArrayList<String>();
		validation.add("3");
		validation.add("f");
		validation.add("e");
		
		Validator.validateNumbers(validation);
	}
	
	@Test
	public void testInterVar() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupStoreSingle(0, "~{45.2,100}");
		InterVar.parseInternalVar(new String[] {"v100"});
		Assert.assertEquals(45.2, Float.parseFloat(InterVar.getParsedNumbers().get(0)), 0.1);
	}
	
	@Test
	public void testParseInternalFunctions() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		List<String> test = soup.getMainLogic().p.parseInternalFunctions(0, "S(P{hello world,1}!0)");
		
		for (String f : test) {
			System.out.println(f);
		}
		Assert.assertEquals("P{hello world,1}", test.get(0));
	}
}