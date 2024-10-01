package factory_design_pattern;

import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class MyLogger {
	private static Logger logger;
	//Creating a method that returns an instance of logger
	public static Logger getLogger() {
		if(logger == null) {
			try {
				logger = Logger.getLogger(MyLogger.class.getName());
				
				//Eliminating default logger
				Logger rootLogger = Logger.getLogger("");
				Handler[] handlers = rootLogger.getHandlers();
				for(Handler handler: handlers) {
					rootLogger.removeHandler(handler);
				}
				
				//Creates a template.log file to store loggs data
				FileHandler fh = new FileHandler("character.log",true);
				
				//decides text format of the file
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);
				
				//Assign filehandler to logger
				logger.addHandler(fh);
				
				logger.setLevel(Level.INFO);
				System.out.println("Logger initialize successfully...");
			} catch (SecurityException e) {
                System.out.println("Security exception in initializing logger: " + e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("I/O exception in initializing logger: " + e.getMessage());
                e.printStackTrace();
            }
		}
		
		return logger;
	}
}
