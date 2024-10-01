package factory_design_pattern;

public class Priest extends Character{
	String profession;
	public Priest(String type, String name,int health, int life) {
		super(name, health, life);
		this.profession = type;
	}
	
	//Methods that describes this character
	@Override
	public void Showattack() {
		System.out.println(name+" don't prefer to participate in combat");
	}
	@Override
	public void Showdefence() {
		System.out.println(name+" uses learning of bible to bring enemy on right path");
	}
	
	@Override
	public void Showweapons() {
		System.out.println(name+"'s weapon Knowledge of rituals, religion, origin of world etc. ");
	}
	@Override
	public void ShowgetStrength() {
		System.out.println("Strength of "+name+": "+health);	
	}
	
	@Override
	public void Showappearance() {
		System.out.println("A priest is a religious leader authorized to perform the sacred rituals of a religion, "
				+ "Showespecially as a mediatory agent between humans and one or more deities.");
	}
}
