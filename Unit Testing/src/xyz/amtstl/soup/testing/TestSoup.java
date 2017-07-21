package xyz.amtstl.soup.testing;

import org.junit.Test;

import junit.framework.Assert;
import xyz.amtstl.soup.Parser;
import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.logic.LogicController;

public class TestSoup {
	Soup soup = new Soup();
	
	@Test
	public void testParseFunc() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		soup.parseFunc('+', 0, "+{4,4}");
		
		Assert.assertEquals(8.0, LogicController.getLastResult(), 0.0);
	}
	
	@Test
	public void checkToken() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		soup.checkToken(0, "+{5,6}", '+');
		
		Assert.assertEquals(11.0, LogicController.getLastResult(), 0.0);
	}
	
	@Test
	public void getMainLogic() {
		if (soup.logic instanceof LogicController) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}