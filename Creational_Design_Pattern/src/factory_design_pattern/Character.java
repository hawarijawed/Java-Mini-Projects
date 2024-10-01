package factory_design_pattern;

public abstract class Character {
	//Feature of character
	protected String name;
	protected int health;
	protected int life;
	public Character(String name, int health, int life) {
		this.name = name;
		this.health = health;
		this.life = life;
	}
	//It contains methods that all the sub classes will override
	public abstract void Showattack();
	public abstract void Showdefence();
	public abstract void Showweapons();
	public abstract void ShowgetStrength();
	public abstract void Showappearance();
	
	//Getters and setters
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health += health;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life += life;
	}
	@Override
	public String toString() {
		return "Name: "+name+"\nHealth: "+health+"hp\nLife: "+life;
	}
}
