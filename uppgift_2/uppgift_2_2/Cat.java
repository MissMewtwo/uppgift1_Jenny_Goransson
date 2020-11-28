package uppgift_2_2;

public class Cat {
	String name;
	String race;
	Owner owner;
	
	
	public Cat (String name, String race) {
		this.name = name;
		this.race = race;
		
		
	}
	
	public void setOwner (Owner matte) {
		this.owner = matte;
	}

}
