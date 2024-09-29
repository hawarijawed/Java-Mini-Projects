package builder_design_pattern;

public class Cars {
	//specifications of cars
	private String engine_name;
	private int no_seats;
	private double fuel;
	private boolean gps_provided;
	private boolean manual_gear;
	
	private Cars(CarBuilder build) {
		this.engine_name = build.engine_name;
		this.no_seats = build.no_seats;
		this.fuel = build.fuel;
		this.gps_provided = build.gps_provided;
		this.manual_gear = build.manual_gear;
	}
	
	@Override
	public String toString() {
		return "Car [Engine: " + engine_name + 
	               ", Seats: " + no_seats + 
	               ", Fuel Capacity: " + fuel + 
	               ", GPS: " + (gps_provided ? "Yes" : "No") + 
	               ", Manuel Gear: " + (manual_gear ? "Yes" : "No") + "]";
	}
	
	//Building a car builder class which provides a car with all specifications
	public static class CarBuilder{
		private String engine_name;
		private int no_seats;
		private double fuel;
		private boolean gps_provided;
		private boolean manual_gear;
		
		//Methods to assemble all the feature of cars
		public CarBuilder setEngine(String engine) {
			this.engine_name = engine;
			return this;
		}
		
		public CarBuilder addSeats(int seat) {
			this.no_seats = seat;
			return this;
		}
		
		public CarBuilder addFuelTank(double d) {
			this.fuel = d;
			return this;
		}
		
		public CarBuilder addGPS(boolean gps) {
			this.gps_provided = gps;
			return this;
		}
		
		public CarBuilder addGear(boolean manual) {
			this.manual_gear = manual;
			return this;
		}
		
		public Cars Build() {
			return new Cars(this);
		}
	}
}
