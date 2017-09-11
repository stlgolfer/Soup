package xyz.amtstl.soup.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompilerWriter {
	private static List<String> outputs = new ArrayList<String>();
	
	public static List<String> getOutputs() {
		return outputs;
	}
	
	public static void writeJavaFile() {
		FileWriter fw;
		
		try {
			//fw = new FileWriter(new File(System.getenv().get("user.dir")));
			fw = new FileWriter(new File("C:/users/alex/desktop/soup compiler/Compiled.java"));
			
			// write class
			fw.write("public class Compiled {\n public static void main(String args[]) {\n");
			
			// write the commands
			for (String e : outputs) {
				fw.write("System.out.println(" + e + ");");
			}
			
			// close up line endings
			fw.write("}}");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void handleNS(List<String> input) {
	}
}