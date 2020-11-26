package uppgift_2_1;

public class Main {
	
	public static void main(String[] args) {
	Cats catOne = new Cats("Tusse", "Skogskatt");
	Dogs dogs = new Dogs("Snutten", "Bulldog");
	
	
	
	System.out.println("The dogs race is: " + dogs.Dograce + " and it's name is: " + dogs.Dogname);
	System.out.println("The cats race is: " + catOne.Catrace + " and it's name is: " + catOne.Catname);
	}
	
}
