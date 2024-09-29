package builder_design_pattern;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.io.IOException;
public class MyLogger {
	private static Logger logger;
	public static Logger getLogger() {
		if(logger == null) {
			try {
				//Creating a logging instance
				logger = Logger.getLogger(MyLogger.class.getName());
				
				//Removing default console log handlers
				Logger rootLogger = Logger.getLogger("");
				Handler[] handlers = rootLogger.getHandlers();
				for(Handler handler: handlers) {
					rootLogger.removeHandler(handler);
				}
				
				FileHandler fh = new FileHandler("cars.log",true);
				SimpleFormatter fomatter = new SimpleFormatter();
				fh.setFormatter(fomatter);
				
				logger.addHandler(fh);
				logger.setLevel(Level.ALL);
				System.out.println("Logger initialization complete..");
				
			}catch(IOException e){
				System.out.println("Logger initialization failed.. "+e.getMessage());
			}
		}
		return logger;
	}
}
