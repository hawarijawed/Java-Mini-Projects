package composite_design_pattern;

public abstract class MenuSet {
	public void addComponent(MenuSet component) {
		throw new UnsupportedOperationException("Invalid operation");
	}
	
	public void removeComponent(MenuSet component) {
		throw new UnsupportedOperationException("Invalid operation");
	}
	
	public MenuSet getChild(int i) {
		throw new UnsupportedOperationException("Invalid operation");
	}
	
	public String getName() {
		throw new UnsupportedOperationException("Invalid operation");
	}
	
	public abstract void show();
}
