package factory_design_pattern;

import java.util.logging.Logger;
import java.util.logging.Level;
public class CharacterFactory {
	Logger logger = MyLogger.getLogger();
	public  Character ProduceCharacter(String type,String name) {
		logger.log(Level.INFO,"Inside the Character Factor class method..");
		switch(type.toLowerCase()) {
		case "assassin":
			logger.log(Level.INFO,"Character Assassin is updating");
			return new Assassin(type,name, 150, 3);
		case "warrior":
			logger.log(Level.INFO,"Character Warrior is updating");
			return new Warrior(type, name, 200, 3);
		case "wizard":
			logger.log(Level.INFO,"Character Wizard is updating");
			return new Wizard(type, name, 135, 2);
		case "archer":
			logger.log(Level.INFO,"Character Archer is updating");
			return new Archer(type, name, 145, 3);
		case "priest":
			logger.log(Level.INFO,"Character Priest is updating");
			return new Priest(type, name, 115, 2);
		case "berserk":
			logger.log(Level.INFO,"Character Berserk is updating");
			return new Berserker(type, name, 300, 2);
		default:
			logger.log(Level.WARNING,"Invalid warriro type "+type);
			throw new IllegalArgumentException("Unknown character input "+type);
		}
	}

}
