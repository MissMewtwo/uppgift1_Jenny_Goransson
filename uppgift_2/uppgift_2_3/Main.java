package uppgift_2_3;

public class Main {
	public static void main(String[] args) {
		
		Hundar[] teoHundar = new Hundar[3];
		Hundar perlan = new Hundar ("Perlan", "Bulldog");
		Hundar greta = new Hundar ("Greta", "Schäfer");
		Hundar nisse = new Hundar ("Nisse", "Pudel");
		teoHundar[0] = perlan;
		teoHundar[1] = greta;
		teoHundar[2] = nisse;
		Husse teo = new Husse ("Teo", teoHundar);
		
		
		
		System.out.println(teo.name + " owns alot of dogs, they are " + teo);
		
		
	}

}
