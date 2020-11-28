package uppgift_2_2;

public class Main {
	public static void main(String[] args) {
		
		Owner lisaOne = new Owner("Lisa");
		Cat tusseOne = new Cat ("Tusse", "katt");
		
		tusseOne.setOwner(lisaOne);
		lisaOne.setCat(tusseOne);
		
		System.out.println(tusseOne.name + " is a cat owned by " + tusseOne.owner.name);
		System.out.println(lisaOne.name + " have a cat named " + tusseOne.name);
		
		
		
		
		
	}

}
