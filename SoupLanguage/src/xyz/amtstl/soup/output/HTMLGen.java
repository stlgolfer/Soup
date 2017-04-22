package xyz.amtstl.soup.output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xyz.amtstl.soup.logic.VariableHandler;

public class HTMLGen {
	private static List<Float> totalOutputs = new ArrayList<Float>();
	
	/*public HTMLGen() {
		totalOutputs = new ArrayList<Float>();
	}*/
	
	public static List<Float> getTotalOutputs() {
		return totalOutputs;
	}
	
	public static void generateOutputDocumentation() throws IOException {
		//FileWriter f = new FileWriter(System.getProperty("user.dir" + "/SoupNoodle.html"));
		FileWriter f = new FileWriter("c:/users/amigala/desktop/noodle.html");
		
		f.write("<style>h1 {	color: blue;}p {	color: red;}div {	display: flex;	align-items: center;	justify-content: center;	flex-direction: column;}</style><title>Soup Noodle</title><center><h1>Soup Noodle Session</h1></center><div><p>Local Vars</p><ul>");
		writeVars(f);
		f.write("</ul><p>Outputs</p><ul>");
		writeOutputs(f);
		f.write("</ul></div>");
		f.close();
	}
	
	private static void writeVars(FileWriter j) throws IOException {
		for (float a : VariableHandler.getVarStore()) {
			j.write("<li>" + String.valueOf(a) + "</li>");
		}
	}
	
	private static void writeOutputs(FileWriter j) throws IOException {
		for (float a : totalOutputs) {
			j.write("<li>" + String.valueOf(a) + "</li>");
		}
	}
}