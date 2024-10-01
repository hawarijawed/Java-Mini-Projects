package factory_design_pattern;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = MyLogger.getLogger();
		logger.log(Level.INFO,"Instantiating scanner object");
		Scanner sc = new Scanner(System.in);
		logger.log(Level.INFO,"Asking for character name");
		System.out.print("Enter name of the character: ");
		String name = sc.nextLine();
		logger.log(Level.INFO,"Asking for profession of character");
		System.out.println("Enter profession of the characater(warrior/Assassin/Wizard/Archer/Berserk/Priest): ");
		String profession = sc.nextLine();
		
		
		CharacterFactory charFactory = new CharacterFactory();
		logger.log(Level.INFO,"Creating a character from CharacterFactory object");
		Character character = charFactory.ProduceCharacter(profession, name);
		logger.log(Level.INFO,"Showing first overview of character");
		System.out.println("Character overview "+character);
		character.Showattack();
		character.Showdefence();
		character.Showweapons();
		character.Showappearance();
		System.out.println();
		String input = "";
		logger.log(Level.INFO,"Asking for update in character life/health");
		System.out.print("Would you like to upgrade your character: ");
		input = sc.nextLine();
		if(input.toLowerCase().equals("yes")) {
			logger.log(Level.INFO,"Asking which feature of character user wants to update");
			System.out.println("Which feature would you like to update: 1.Health\t2.Life");
			String feature = sc.nextLine();
			
			//Input validation
			if(!feature.toLowerCase().equals("health") && !feature.toLowerCase().equals("life")) {
				logger.log(Level.INFO,"Invalid feature input by user...");
				System.out.println("Invalid input..");
			}
			
			logger.log(Level.INFO,"Asking how much "+feature+" user want to add in character");
			
			System.out.print("Enter the extra "+feature+" you would like to add: ");
			int extra = sc.nextInt();
			UpdateClass update = new UpdateClass();
			logger.log(Level.INFO,"Character updation instantiated using UpdateClass..");
			update.updateCharacter(character, feature, extra);
			logger.log(Level.INFO,"Presenting the overview of character after update");
			System.out.println("Character after update "+character);
		}
		
		sc.close();
		logger.log(Level.INFO,"Closing the main function...");
	}

}
