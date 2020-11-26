package uppgift_2_2;

public class Main {
	public static void main(String[] args) {
		
		Cat tusseOne = new Cat ("Tusse", "Norsk skogskatt", 1);
		Owner lisaOne = new Owner("Lisa", 1);
		
		
		System.out.println(lisaOne.name + " owns a " + tusseOne.race + " named " + tusseOne.name);
	}

}
