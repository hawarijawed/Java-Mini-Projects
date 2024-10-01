package factory_design_pattern;

public class Archer extends Character{
	String profession;
	public Archer(String type, String name,int health, int life) {
		super(name, health, life);
		this.profession = type;
	}
	
	//Methods that describes this character
	@Override
	public void Showattack() {
		System.out.println(name+"'s attack bow and arrow, expert hand to hand combat, long range fighter");
	}
	@Override
	public void Showdefence() {
		System.out.println(name+"'s defence: Cross bow, Triple hat combat");
	}
	
	@Override
	public void Showweapons() {
		System.out.println(name+" used ongbows, recurve bows, and crossbows");
	}
	@Override
	public void ShowgetStrength() {
		System.out.println("Strength of "+name+": "+health);
		
	}	
	@Override
	public void Showappearance() {
		System.out.println(name+" most often use a bow and arrow as weapons. Players can use this beneficial trait in both long-distance combat, as well as close combat in which it can cause serious damage.");
	}
}
