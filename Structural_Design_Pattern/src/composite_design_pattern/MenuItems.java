package composite_design_pattern;

public class MenuItems extends MenuSet {
	
	private String Item_name;
	//constructor
	public MenuItems(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name of menu item can not be empty");
		}
		this.Item_name = name;
	}
	@Override
	public String getName() {
		return Item_name;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Menu items "+getName());
	}

}
