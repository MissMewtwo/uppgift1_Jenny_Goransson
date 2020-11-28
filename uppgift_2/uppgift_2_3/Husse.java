package uppgift_2_3;

public class Husse {
	String name;
	Hundar[] dogs;
	
	public Husse(String name, Hundar[] dogs) {
		this.name = name;
		this.dogs = dogs;
	}
	
	public String toString() {
		String toReturn = "";
		for(int i = 0; i<this.dogs.length; i++) {
			toReturn += this.dogs[i].name + " ";
			if(i== this.dogs.length - 2) {
				toReturn += "and ";
			}
		}
		
		return toReturn;
		
	}

}
