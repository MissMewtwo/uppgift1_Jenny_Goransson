package uppgift_2_3;

public class Main {
	public static void main(String[] args) {
		
		Hundar[] teoHundar = new Hundar[4];
		Hundar perlan = new Hundar ("Perlan", "Bulldog");
		Hundar greta = new Hundar ("Greta", "Schäfer");
		Hundar nisse = new Hundar ("Nisse", "Pudel");
		Hundar lisa = new Hundar ("Lisa", "Pudel");
		teoHundar[0] = perlan;
		teoHundar[1] = greta;
		teoHundar[2] = nisse;
		teoHundar[3] = lisa;
		Husse teo = new Husse ("Teo", teoHundar);
		
		
		
		System.out.println(teo.name + " owns alot of dogs, they are " + teo);
		
		
	}

}
