package mediator_design_pattern;

public interface securityWall {
	void forwardMessage(String message, Device sender, String receiverid);
	void registerDevice(Device device);
}


class Device{
	private String device_id;
	private securityWall firewall;
	public Device(String dev_id, securityWall firewall) {
		this.device_id = dev_id;
		this.firewall = firewall;
	}
	
	public String getDevice_id(){
		return device_id;
	}
	public void send(String message, String receiverid) {
		System.out.println(device_id+" is attempting to communicate with "+receiverid+": "+message);
		firewall.forwardMessage(message, this, receiverid);
	}
	
	public void receive(String message, String sender) {
		System.out.println(device_id+" received a message from "+sender+": "+message);
	}
}

