package template_design_pattern;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TextFileProcessing extends FileHandling {
	private String file_contents;
	private boolean file_exist = true;
	private StringBuilder sb = new StringBuilder();
	private Logger logs = MyLogger.getLogger();
	@Override
	public void readFile(String path) {
		logs.log(Level.INFO,"Inside the readFile method");
		System.out.println("Reading the file content");
		//Content of the file are accessed here and stored in file_contents
		//variable
//		file_contents = "Sample contents from the given file";
		logs.log(Level.INFO, "Creating a file reader");
		try(BufferedReader reader = new BufferedReader(new FileReader(path))){
			String lines;
//			int num=0;
//			char ch;
			logs.log(Level.INFO,"Data reading of input file initiated...");
			while((lines = reader.readLine()) != null) {
//				ch = (char)num;
				sb.append(lines).append("\n");
			}
			logs.log(Level.INFO,"Data reading of input file successfull...");
		}catch(IOException e) {
			logs.log(Level.INFO,"Could not read the "+path+" due to internal error");
			System.out.println("Error in reading file "+e.getMessage());
			file_exist = false;
			return;
		}
		
		file_contents = sb.toString();
		logs.log(Level.INFO,"Printing the contents for the input file");
		System.out.println("Contents of the file...");
		System.out.println(file_contents);
		logs.log(Level.INFO,"Leaving the readFile() method...");
	}
	
	
	@Override
	public void processData() {
		logs.log(Level.INFO,"Entering into processData() method...");
		if(!file_exist) {
			logs.log(Level.INFO,"File does not exist, exiting processData()...");
			System.out.println("File could not be processed due to reading errors.");
			return;
		}
		logs.log(Level.INFO,"Analysing and printing the content of file");
		System.out.println("Analyzing the data from file");
		//Logic of what operation need to be performed on the file data
		//e.g. counting words, total Sentences, searching number in file
		System.out.println("File contents are "+file_contents);
		logs.log(Level.INFO,"Exiting the processData() Method...");
	}
}
