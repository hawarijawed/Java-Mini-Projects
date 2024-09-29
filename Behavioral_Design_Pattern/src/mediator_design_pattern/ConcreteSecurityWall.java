package mediator_design_pattern;
import java.util.HashMap;
import java.util.HashSet;
public class ConcreteSecurityWall implements securityWall{
	private HashMap<String, Device> devices = new HashMap<>();
	private HashSet<String> allowedCommunications = new HashSet<>();
	
	public void addAllowedCommunication(String device1_id, String device2_id) {
		allowedCommunications.add(device1_id+"-"+device2_id);
	}
	
	@Override
	public void forwardMessage(String message, Device sender, String receiverid) {
		if(!devices.containsKey(receiverid)) {
			System.out.println("Device "+receiverid+" not found in the network.");
			return;
		}
		
		//Converting to pair to search from HashSet
		String communicationPair = sender.getDevice_id()+"-"+receiverid;
		
		if(allowedCommunications.contains(communicationPair)) {
			devices.get(receiverid).receive(message, sender.getDevice_id());
		}
		else {
			System.out.println("Failed to establish communication between "+sender.getDevice_id()+" and "+receiverid);
		}
	}
	
	@Override
	public void registerDevice(Device device) {
		//add device in the devices hashmap
		devices.put(device.getDevice_id(), device);
	}
}
