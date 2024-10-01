package factory_design_pattern;

public class Berserker extends Character{
	String profession;
	public Berserker(String type, String name,int health, int life) {
		super(name, health, life);
		this.profession = type;
	}
	
	//Methods that describes this character
	@Override
	public void Showattack() {
		System.out.println(name+" attacks with lethal punches and kick.");
	}
	@Override
	public void Showdefence() {
		System.out.println(name+" use the weapons as shield");
	}
	
	@Override
	public void Showweapons() {
		System.out.println(name+" uses Axe, Double Axe, Busted Blade, Chain Whip");
	}
	@Override
	public void ShowgetStrength() {
		System.out.println("Strength of "+name+": "+health);
		
	}
	
	@Override
	public void Showappearance() {
		System.out.println(name+" ");
	}
}
