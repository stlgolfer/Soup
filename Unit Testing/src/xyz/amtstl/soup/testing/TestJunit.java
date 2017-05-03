package xyz.amtstl.soup.testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.misc.IO;

public class TestJunit {
	private static Soup soup = new Soup();
	
	@Test
	public void testSoupAdd() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupSubtract(0, "_{10,5}");
		
		float rest = soup.logic.getLastResult();
		
		Assert.assertEquals(5.0, rest, 0.0);
	}
	
	@Test
	public void testSoupSubtract() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupAdd(0, "+{4,5}");
		
		float res = soup.logic.getLastResult();
		
		Assert.assertEquals(9.0, res, 0.0);
	}
	
	@Test
	public void testSoupMultiply() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupMultiply(0, "*{5,5}");
		
		float res = soup.logic.getLastResult();
		
		Assert.assertEquals(25.0, res, 0.0);
	}
	
	@Test
	public void testSoupDivide() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupDivide(0, "%{10,5}");
		
		float res = soup.logic.getLastResult();
		
		Assert.assertEquals(2.0, res, 0.0);
	}
	
	@Test
	public void testSoupPow() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupPow(0, "^{2,3}");
		
		float res = soup.logic.getLastResult();
		
		Assert.assertEquals(8.0, res, 0.0);
	}
	
	@Test
	public void testSoupLog() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupLog(0, "#{2}");
		
		float res = soup.logic.getLastResult();
		
		Assert.assertEquals(0.301029957, res, 0.100000000);
	}
	
	@Test
	public void testSoupTrig() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		/*
		 * Will need to test all iterations of the trig functions
		 */
		
		// sine
		soup.logic.soupTrig(0, "${s,3}");
		float sine = soup.logic.getLastResult();
		
		Assert.assertEquals(0.1411200081, sine, 0.1000);
		
		// cosine
		soup.logic.soupTrig(0, "${c,3}");
		float cosine = soup.logic.getLastResult();
		
		Assert.assertEquals(-0.9899924966, cosine, 0.1000);
		
		// tangent
		soup.logic.soupTrig(0, "${t,3}");
		float tangent = soup.logic.getLastResult();
				
		Assert.assertEquals(-0.1425465431, tangent, 0.1000);
		
		/*
		 * ARC FUNCTIONS ARE BROKEN
		 */
	}
	
	@Test
	public void testSoupArea() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupArea(0, "A{s,4,5}");
		
		float square = soup.logic.getLastResult();
		Assert.assertEquals(20.0, square, 0.0);
		
		// triangle
		soup.logic.soupArea(0, "A{tri,4,5}");
		
		float triangle = soup.logic.getLastResult();
		Assert.assertEquals(10.0, triangle, 0.0);
		
		// trapezoid
		soup.logic.soupArea(0, "A{tra,1,5,7}");
		
		float trapezoid = soup.logic.getLastResult();
		Assert.assertEquals(21.0, trapezoid, 0.0);
	}
	
	@Test
	public void testSoupAbs() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupAbs(0, "|{-347.4}");
		
		/*
		 * note that abs is accurate to 0.1
		 */
		float abs = soup.logic.getLastResult();
		Assert.assertEquals(347.4, abs, 0.1);
	}
	
	@Test
	public void testSoupRound() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupRound(0, "?{5.6}");
		
		/*
		 * 100 percent accuracy
		 */
		float round = soup.logic.getLastResult();
		Assert.assertEquals(6, round, 0.0);
	}
	
	@Test
	public void testSoupSquareRoot() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupSquareRoot(0, "&{5}");
		
		float squareroot = soup.logic.getLastResult();
		
		Assert.assertEquals(2.236067977, squareroot, 0.01);
	}
	
	@Test
	public void testSoupRandom() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupRandomNum(0, "R{0,10}");
		
		float randnum = soup.logic.getLastResult();
		boolean success = false;
		
		if (randnum < 10 && randnum > 0) {
			IO.println("RANDNUM: " + String.valueOf(randnum));
			success = true;
		}
		
		Assert.assertTrue(success);
	}
	
	@Test
	public void testSoupIf() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.logic.soupIf(0, "={4,4}");
		
		Assert.assertTrue(soup.logic.ifState);
		
		soup.logic.v.insertVar((float) 4.3, 10);
		
		soup.logic.soupIf(0, "={v10,3}");
		
		Assert.assertFalse(soup.logic.ifState);
	}
}