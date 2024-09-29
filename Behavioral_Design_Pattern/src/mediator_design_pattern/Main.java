package mediator_design_pattern;

public class Main {
	public static void main(String[] args) {
		System.out.println("Aur batao kaise ho");
		//Create an instance of ConcreteSecurityWall
		ConcreteSecurityWall firewall = new ConcreteSecurityWall();
		
		//Create 3-4 devices
		Device device_1 = new Device("Device 1", firewall);
		Device device_2 = new Device("Device 2", firewall);
		Device device_3 = new Device("Device 3", firewall);
		Device device_4 = new Device("Device 4", firewall);
		Device device_5 = new Device("Device 5", firewall);
		Device device_6 = new Device("Device 6", firewall);
		
		//Register devices with the firewall
		firewall.registerDevice(device_1);
		firewall.registerDevice(device_2);
		firewall.registerDevice(device_3);
		firewall.registerDevice(device_4);
		firewall.registerDevice(device_5);
		
		//Specifying which device can communicate with whom
		firewall.addAllowedCommunication("Device 1", "Device 2");
		firewall.addAllowedCommunication("Device 1", "Device 3");
		firewall.addAllowedCommunication("Device 2", "Device 4");
		firewall.addAllowedCommunication("Device 3", "Device 5");
		
		device_1.send("Hellow, device 2", "Device 2");
		device_1.send("Hi.. how are you", "Device 4");
		
		device_3.send("Hello, its your friend here", "Device 5");
		device_5.send("Hey!!! hellow. How are you doing there", "Device 3");
		
		device_6.send("Do any one remember me","Device 3");
		
	}
}
