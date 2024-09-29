package template_design_pattern;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FileHandling {
	//Flow of file processing
	private Logger logs = MyLogger.getLogger(); 
	public final void fileProcessing(String path) {
		logs.log(Level.INFO,"Entering the fileProcessing method...");
		//Order of execution
		openFile(path);
		readFile(path);
		processData();
		closeFile();
	}
	
	public void openFile(String path) {
		logs.log(Level.INFO,"Attempting to open file "+path);
		System.out.println("Attempting to open file: "+path);
		logs.info("Exiting from openFile() method...");
	}
	
	//methods to be overriden by subclasses
	public abstract void readFile(String path);
	public abstract void processData();
	
	//Common method for all fileHandling
	public void closeFile() {
		System.out.println("Closing the file...");
	}
}
