package factory_design_pattern;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateClass {
	Logger logger = MyLogger.getLogger();
	protected void updateCharacter(Character ch, String feature, int extra) {
		logger.log(Level.INFO,"Inside the update character class...");
		System.out.println("Upgrading the character "+ch.name);
		logger.log(Level.INFO,"Matching the character attribute...");
		switch(feature.toLowerCase()) {
		case "health":
			logger.log(Level.INFO,"Setting up the character health");
			ch.setHealth(extra);
			break;
		case "life":
			logger.log(Level.INFO,"Setting up the character life");
			ch.setLife(extra);
		default:
			logger.log(Level.WARNING,"Invalid feature update asked !!!");
			throw new IllegalArgumentException("Invalid update "+extra);
		}
	}
}
