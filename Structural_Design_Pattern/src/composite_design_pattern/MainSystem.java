package composite_design_pattern;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainSystem {
	public static void main(String[] args) {
		Logger logger = MyLogger.getLogger();
        try {
            // Create menu components
            MenuSet mainMenu = new MenuUpdate("Main Menu");
            MenuSet breakfastMenu = new MenuUpdate("Breakfast Menu");
            MenuSet lunchMenu = new MenuUpdate("Lunch Menu");

            MenuSet pancakeItem = new MenuUpdate("Pancakes");
            MenuSet omeletteItem = new MenuUpdate("Omelette");
            MenuSet burgerItem = new MenuUpdate("Burger");
            MenuSet sandwichItem = new MenuUpdate("Sandwich");

            // Build menu structure
            breakfastMenu.addComponent(pancakeItem);
            breakfastMenu.addComponent(omeletteItem);
            lunchMenu.addComponent(burgerItem);
            lunchMenu.addComponent(sandwichItem);

            mainMenu.addComponent(breakfastMenu);
            mainMenu.addComponent(lunchMenu);

            //Display the entire menu
            mainMenu.show();

            // Test invalid operations (Exception handling)
            try {
                mainMenu.addComponent(null); // Attempting to add a null item (should throw exception)
            } catch (IllegalArgumentException e) {
                logger.log(Level.WARNING,"Exception caught: " + e.getMessage());
            }

            try {
                lunchMenu.getChild(10); // Accessing invalid child index (should throw exception)
            } catch (IndexOutOfBoundsException e) {
            	logger.log(Level.WARNING,"Exception caught: " + e.getMessage());
            }

        } catch (Exception e) {
        	logger.log(Level.SEVERE,"Exception caught: " + e.getMessage());
        }
    }
}
