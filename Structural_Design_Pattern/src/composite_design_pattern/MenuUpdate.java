package composite_design_pattern;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MenuUpdate extends MenuSet{
	protected List<MenuSet> menu_set = new ArrayList<>();
	protected String name;
	Logger logger = MyLogger.getLogger();
	//Constructor
	public MenuUpdate(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name of menu can not be empty");
		}
		this.name = name;
	}
	
	@Override
	public void addComponent(MenuSet item) {
		if(item == null) {
			logger.log(Level.WARNING,"Trying to add null menu element");
			throw new IllegalArgumentException("Null component can't be added to menu");
		}
		
		menu_set.add(item);
		logger.log(Level.INFO,"Menu element "+item.getName()+" added to "+this.getName());
	}
	
	@Override
	public void removeComponent(MenuSet item) {
		if(menu_set == null) {
			logger.log(Level.WARNING,"Trying to remove null menu element");
			throw new IllegalArgumentException("Null component can't be removed from menu");
		}
		menu_set.remove(item);
		logger.log(Level.INFO,"Item "+item.getName()+" removed from "+this.getName());
	}
	
	@Override
    public MenuSet getChild(int i) {
        if (i < 0 || i >= menu_set.size()) {
            logger.log(Level.WARNING,"Trying to access invalid index: " + i);
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        return menu_set.get(i);
    }
	
	 @Override
	 public String getName() {
	     return name;
     }
	 
	 @Override
	 public void show() {
	     System.out.println("\nMenu: " + getName());
	     for (MenuSet set : menu_set) {
	         set.show();
	     }
	 }
	
}
