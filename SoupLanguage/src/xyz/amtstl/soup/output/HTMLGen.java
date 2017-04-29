package xyz.amtstl.soup.output;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import xyz.amtstl.soup.logic.VariableHandler;
import xyz.amtstl.soup.misc.IO;

public class HTMLGen {
	/**
	 * Total outputs cache
	 */
	private static List<Float> totalOutputs = new ArrayList<Float>();
	
	/**
	 * Total Question Strings cache
	 */
	private static List<String> questionStrings = new ArrayList<String>();
	
	/**
	 * Gets the total output cache
	 * @return total output object
	 */
	public static List<Float> getTotalOutputs() {
		return totalOutputs;
	}
	
	/**
	 * Get question strings
	 * @return total questions strings object
	 */
	public static List<String> getQuestionStrings() {
		return questionStrings;
	}
	
	/**
	 * Generates HTML documentation for the Soup session
	 * @param title title on the window
	 * @param description the header of the page
	 * @throws IOException throws if it cannot store
	 */
	public static void generateOutputDocumentation(String title, String description) throws IOException {
		try {
		FileWriter f = new FileWriter(System.getProperty("user.dir" + "/SoupNoodle.html"));
		//FileWriter f = new FileWriter("c:/users/amigala/desktop/noodle.html");
		//FileWriter f = new FileWriter("c:/users/alex/desktop/noodle.html");
		
			f.write("<style>h1 {	color: blue;}p {	color: red;}div {	display: flex;	align-items: center;	justify-content: center;	flex-direction: column;}</style><title>");
			f.write(title);
			f.write("</title><center><h1>");
			f.write(description + " [" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + "]");
			f.write("</h1></center><div><p>Local Vars</p><ul>");
			writeVars(f);
			f.write("</ul><p>Outputs</p><ul>");
			writeOutputs(f);
			f.write("</ul></div><div><p>Questions Asked</p><ul>");
			writeQuestions(f);
			f.write("</ul></div>");
			f.close();
			IO.println("Output Generated at " + System.getProperty("user.dir") + "\\" + "SoupNoodle.html");
		}
		catch (IOException ex) {
			IO.println("Error storing output documentation at " + System.getProperty("user.dir") + "\\" + "SoupNoodle.html");
		}
	}
	
	/**
	 * Writes variables from cache
	 * @param j current file writer instance
	 * @throws IOException throws if error storing file
	 */
	private static void writeVars(FileWriter j) throws IOException {
		for (float a : VariableHandler.getVarStore()) {
			if (a != 0.0)
				j.write("<li>" + String.valueOf(a) + "</li>");
		}
	}
	
	/**
	 * Writes all the outputs
	 * @param j current file writer instance
	 * @throws IOException throws if error storing file
	 */
	private static void writeOutputs(FileWriter j) throws IOException {
		for (float a : totalOutputs) {
			j.write("<li>" + String.valueOf(a) + "</li>");
		}
	}
	
	/**
	 * Writes all the session's questions
	 * @param j current file writer instance
	 * @throws IOException throws if error storing file
	 */
	private static void writeQuestions(FileWriter j) throws IOException {
		for (String a : questionStrings) {
			j.write("<li>" + a + "</li>");
		}
	}
}