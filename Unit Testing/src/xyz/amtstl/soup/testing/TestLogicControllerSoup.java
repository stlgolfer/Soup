package xyz.amtstl.soup.testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;
import xyz.amtstl.soup.Soup;
import xyz.amtstl.soup.exceptions.SoupFunctionNotDeclaredException;
import xyz.amtstl.soup.exceptions.SoupSyntaxException;
import xyz.amtstl.soup.exceptions.SoupVariableException;
import xyz.amtstl.soup.logic.Looper;
import xyz.amtstl.soup.logic.Looper;

public class TestLogicControllerSoup {
	private static Soup soup = new Soup();
	private static ByteArrayOutputStream stream;
	private static PrintStream printingStream;
	
	public TestLogicControllerSoup() {
		stream = new ByteArrayOutputStream();
		printingStream = new PrintStream(stream);
	}
	
	@Test
	public void testSoupAdd() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupSubtract(0, "_{10,5}");
		
		float rest = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(5.0, rest, 0.0);
	}
	
	@Test
	public void testSoupSubtract() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupAdd(0, "+{4,5}");
		
		float res = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(9.0, res, 0.0);
	}
	
	@Test
	public void testSoupMultiply() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupMultiply(0, "*{5,5}");
		
		float res = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(25.0, res, 0.0);
	}
	
	@Test
	public void testSoupDivide() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupDivide(0, "%{10,5}");
		
		float res = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(2.0, res, 0.0);
	}
	
	@Test
	public void testSoupPow() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupPow(0, "^{2,3}");
		
		float res = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(8.0, res, 0.0);
	}
	
	@Test
	public void testSoupLog() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupLog(0, "#{2}");
		
		float res = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(0.301029957, res, 0.100000000);
	}
	
	@Test
	public void testSoupTrig() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		/*
		 * Will need to test all iterations of the trig functions
		 */
		
		// sine
		soup.getMainLogic().soupTrig(0, "${s,3}");
		float sine = soup.getMainLogic().getLastResult();
		Assert.assertEquals(0.1411200081, sine, 0.1000);
		
		// cosine
		soup.getMainLogic().soupTrig(0, "${c,3}");
		float cosine = soup.getMainLogic().getLastResult();
		Assert.assertEquals(-0.9899924966, cosine, 0.1000);
		
		// tangent
		soup.getMainLogic().soupTrig(0, "${t,3}");
		float tangent = soup.getMainLogic().getLastResult();
		Assert.assertEquals(-0.1425465431, tangent, 0.1000);
		
		// arcsine
		soup.getMainLogic().soupTrig(0, "${arcs,0.3}");
		float arcsine = soup.getMainLogic().getLastResult();
		Assert.assertEquals(0.304692654, arcsine, 0.001);
		
		// arccosine
		soup.getMainLogic().soupTrig(0, "${arcc,0.3}");
		float arccosine = soup.getMainLogic().getLastResult();
		Assert.assertEquals(1.266103673, arccosine, 0.001);
		
		// arctangent
		soup.getMainLogic().soupTrig(0, "${arct,0.3}");
		float arctangent = soup.getMainLogic().getLastResult();
		Assert.assertEquals(0.2914567945, arctangent, 0.001);
	}
	
	@Test
	public void testSoupArea() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupArea(0, "A{s,4,5}");
		
		float square = soup.getMainLogic().getLastResult();
		Assert.assertEquals(20.0, square, 0.0);
		
		// triangle
		soup.getMainLogic().soupArea(0, "A{tri,4,5}");
		
		float triangle = soup.getMainLogic().getLastResult();
		Assert.assertEquals(10.0, triangle, 0.0);
		
		// trapezoid
		soup.getMainLogic().soupArea(0, "A{tra,1,5,7}");
		
		float trapezoid = soup.getMainLogic().getLastResult();
		Assert.assertEquals(21.0, trapezoid, 0.0);
	}
	
	@Test
	public void testSoupAbs() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupAbs(0, "|{-347.4}");
		
		/*
		 * note that abs is accurate to 0.1
		 */
		float abs = soup.getMainLogic().getLastResult();
		Assert.assertEquals(347.4, abs, 0.1);
	}
	
	@Test
	public void testSoupRound() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupRound(0, "?{5.6}");
		
		/*
		 * 100 percent accuracy
		 */
		float round = soup.getMainLogic().getLastResult();
		Assert.assertEquals(6, round, 0.0);
	}
	
	@Test
	public void testSoupSquareRoot() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupSquareRoot(0, "&{5}");
		
		float squareroot = soup.getMainLogic().getLastResult();
		
		Assert.assertEquals(2.236067977, squareroot, 0.01);
	}
	
	@Test
	public void testSoupRandom() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupRandomNum(0, "R{0,10}");
		
		float randnum = soup.getMainLogic().getLastResult();
		boolean success = false;
		
		if (randnum < 10 && randnum > 0) {
			System.out.println("RANDNUM: " + String.valueOf(randnum));
			success = true;
		}
		
		Assert.assertTrue(success);
	}
	
	@Test
	public void testSoupIf() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupIf(0, "={4,4}");
		
		Assert.assertTrue(soup.getMainLogic().ifState);
		
		soup.getMainLogic().v.insertVar((float) 4.3, 10);
		
		soup.getMainLogic().soupIf(0, "={v10,3}");
		
		Assert.assertFalse(soup.getMainLogic().ifState);
	}
	
	@Test
	public void testSoupTestIfLessThan() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupIfLessThan(0, "<{3,5}");
		
		Assert.assertTrue(soup.getMainLogic().ifState);
		
		soup.getMainLogic().soupIfLessThan(0, "<{6,5}");
		
		Assert.assertFalse(soup.getMainLogic().ifState);
	}
	
	@Test
	public void testSoupIfGreaterThan() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupIfGreaterThan(0, ">{5,4}");
		
		Assert.assertTrue(soup.getMainLogic().ifState);
		
		soup.getMainLogic().soupIfGreaterThan(0, ">{3,4}");
		
		Assert.assertFalse(soup.getMainLogic().ifState);
	}
	
	@Test
	public void testSoupIfDo() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		soup.getMainLogic().ifState = true;
		
		soup.getMainLogic().soupIfDo(0, ";(+{5,6}!_{5,4})");
		
		Assert.assertEquals(11.0, soup.getMainLogic().getLastResult(), 0.0);
		
		soup.getMainLogic().ifState = false;
		
		soup.getMainLogic().soupIfDo(0, ";(+{5,6}!_{5,4})");
		
		Assert.assertEquals(1.0, soup.getMainLogic().getLastResult(), 0.0);
	}
	
	@Test
	public void testSoupRetrieveVar() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupStoreSingle(0, "~{4,100}");
		System.out.println("Requested var is 4 at index:100");
		System.out.println("===Retrieved Var===");
		soup.getMainLogic().soupRetrieveVar(0, "V{100}");
	}
	
	@Test
	public void testSoupStoreVar() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupSubtract(0, "_{8,0.8}");
		soup.getMainLogic().soupStoreVar(0, ":{200}");
		Assert.assertEquals(7.2, soup.getMainLogic().getLastResult(), 0.1);
	}
	
	@Test
	public void testSoupStoreSingle() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupStoreSingle(0, "~{34.6,123}");
		
		Assert.assertEquals(34.6, soup.getMainLogic().v.getVar(123), 0.1);
	}
	
	@Test
	public void testSoupStoreGetFunction() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		soup.getMainLogic().soupStoreFunction(0, "S(+{3,3}:{5}!0)");
		soup.getMainLogic().soupGetFunction(0, "F{0}");
		Assert.assertEquals(6, soup.getMainLogic().getLastResult(), 0.0);
	}
	
	@Test
	public void testSoupRefreshNumbers() throws NumberFormatException, SoupVariableException, SoupSyntaxException {
		soup.getMainLogic().soupRefreshNumbers(0, "+{3,4,6,7,78,90,14300}");
		
		String[] reals = new String[] {"3","4","6","7","78","90","14300"};
		
		for (int e = 0; e < soup.getMainLogic().ns.size(); e++) {
			Assert.assertEquals(reals[e], soup.getMainLogic().ns.get(e));
		}
	}
	
	@Test
	public void testSoupBreakLoop() {
		soup.getMainLogic().soupBreakLoop();
		
		Assert.assertTrue(soup.getMainLogic().isBreak);
	}
	
	@Test
	public void testSoupComment() throws NumberFormatException, SoupVariableException {
		String test = "+{5,4} // this is a comment";
		soup.getMainLogic().soupComment(0, test);
		
		Assert.assertEquals(test.length(), soup.getMainLogic().getIndex());
	}
	
	@Test
	public void testSetIndex() {
		soup.getMainLogic().setIndex(0);
		soup.getMainLogic().setIndex(5);
		
		Assert.assertEquals(5, soup.getMainLogic().getIndex());
	}
	
	/*
	 * Soup functions
	 */
	
	@Test
	public void testParseFunc() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		soup.parseFunc('_', 0, "_{5.3,5.2}");
		
		Assert.assertEquals(0.1, soup.getMainLogic().getLastResult(), 0.1);
	}
	
	@Test
	public void testCheckToken() throws NumberFormatException, SoupVariableException, SoupSyntaxException, SoupFunctionNotDeclaredException {
		soup.checkToken(0, "*{200,150}", '*');
		
		Assert.assertEquals(30000, soup.getMainLogic().getLastResult(), 0.0);
	}
}