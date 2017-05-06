package xyz.amtstl.soup.testing;

import org.junit.Test;

import junit.framework.Assert;
import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.logic.Looper;
import xyz.amtstl.soup.misc.IO;

public class TestLooping {
	private static Soup soup = new Soup();
	
	@Test
	public void testForLoop() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		Looper.execNewForLoop(0, 3, "+{3,4}", " ");
		
		Assert.assertEquals(3.0, soup.logic.v.getVar(1000), 0.0);
	}
	
	@Test
	public void testWhileLoop() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupWhileLoop(0, "W{1,0}._{9,4}");
		
		IO.printFloat(soup.logic.getLastResult());
		
		//Assert.assertEquals(5.0, soup.logic.getLastResult(), 0.0);
	}
}