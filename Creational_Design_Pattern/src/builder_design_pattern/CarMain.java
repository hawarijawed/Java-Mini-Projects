package builder_design_pattern;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
public class CarMain {
	public static void main(String[] args) {
		Logger logger = MyLogger.getLogger();
		Scanner sc = new Scanner(System.in);
		CarConstruction Constructor = new CarConstruction();
		logger.log(Level.INFO,"Asking from user their preference");
		System.out.println("Which model you would like to choose");
		System.out.println("1. Sports Car\t2. Family Car\t3. Electric Car");
		String model = sc.nextLine();
		logger.log(Level.INFO,"User gave its preference");
		if(model.equals("Sport")) { 
			logger.log(Level.INFO,"User opted for sport car");
			Cars sportCar = Constructor.sportCarConstruct(new Cars.CarBuilder());
			System.out.println("Your sports car is ready: "+sportCar);
			logger.log(Level.INFO,"Car is read..");
		}
		else if(model.equals("Family")) {
			logger.log(Level.INFO,"User opted for family car");
			Cars familyCar =  Constructor.sportCarConstruct(new Cars.CarBuilder());
			System.out.println("Your sports car is ready: "+familyCar);
			logger.log(Level.INFO,"Car is read..");
		}
		else if(model.equals("Electric")) {
			logger.log(Level.INFO,"User opted for electric car");
			Cars electricCar =  Constructor.sportCarConstruct(new Cars.CarBuilder());
			System.out.println("Your sports car is ready: "+electricCar);
			logger.log(Level.INFO,"Car is read..");
		}
		else {
			logger.log(Level.INFO,"User gave invalid input");
			System.out.println("Invalid input");
		}
		sc.close();
		logger.log(Level.INFO,"Closing the main function");
	}
}
