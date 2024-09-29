package builder_design_pattern;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CarConstruction {
	Logger logger = MyLogger.getLogger();
	public Cars sportCarConstruct(Cars.CarBuilder build) {
		logger.log(Level.INFO,"Adding engine to sport car...");
		build.setEngine("V12 engine");
		logger.log(Level.INFO,"Adding seats in sport car...");
		build.addSeats(2);
		logger.log(Level.INFO,"Fuel tank is injected to sport car...");
		build.addFuelTank(100.0);
		logger.log(Level.INFO,"Implementing gps in car...");
		build.addGPS(true);
		logger.log(Level.INFO,"Adding manual gear to sport car...");
		build.addGear(true);
		logger.log(Level.INFO,"Sport car is ready to roll...");
		return build.Build();
	}
	
	//Family car construction
	public Cars familyCarConstruct(Cars.CarBuilder build) {
		logger.log(Level.INFO,"Adding engine to family car...");
		build.setEngine("V engine");
		logger.log(Level.INFO,"Adding seats in family car...");
		build.addSeats(7);
		logger.log(Level.INFO,"Fuel tank is injected to family car...");
		build.addFuelTank(56);
		logger.log(Level.INFO,"Implementing gps in family car...");
		build.addGPS(true);
		logger.log(Level.INFO,"Adding manual gear to family car...");
		build.addGear(true);
		logger.log(Level.INFO,"Family car is ready to roll...");
		return build.Build();
	}
	
	//Electric car construction
	public Cars electricCarConstruct(Cars.CarBuilder build) {
		logger.log(Level.INFO,"Adding engine to family car...");
		build.setEngine("Induction Motor");
		logger.log(Level.INFO,"Adding seats in family car...");
		build.addSeats(7);
		logger.log(Level.INFO,"Fuel tank is injected to family car...");
		build.addFuelTank(0);
		logger.log(Level.INFO,"Implementing gps in family car...");
		build.addGPS(true);
		logger.log(Level.INFO,"Adding manual gear to family car...");
		build.addGear(false);
		logger.log(Level.INFO,"Family car is ready to roll...");
		return build.Build();
	}
}
