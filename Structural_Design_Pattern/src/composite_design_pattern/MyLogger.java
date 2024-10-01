package composite_design_pattern;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	protected static Logger logger;
	public static Logger getLogger() {
		if(logger == null) {
			try {
				
				logger = Logger.getLogger(MyLogger.class.getName());
				
				//Removing default handlers
				Logger RootLogger = Logger.getLogger("");
				Handler[] handlers = RootLogger.getHandlers();
				for(Handler handler: handlers) {
					RootLogger.removeHandler(handler);
				}
				
				FileHandler fh = new FileHandler("Menu.log",true);
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);
				
				logger.addHandler(fh);
				
				logger.setLevel(Level.INFO);
				
			}catch(SecurityException e) {
				System.out.println("Security exception occurred in logger initialization "+e.getMessage());
				e.printStackTrace();
			}catch(IOException e) {
				System.out.println("IO exception occurred in logger initialization "+e.getMessage());
				e.printStackTrace();
			}
		}
		return logger;
	}
}

