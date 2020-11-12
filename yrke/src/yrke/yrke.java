package yrke;
import java.util.Scanner;

public class yrke {

	public static void main(String[] args) {
		System.out.println("1.Pilot, \n2.Brandman, \n3.Badanka, \n4.Frisör, \n5.Mobil");
		System.out.println("Välj ett yrke:");
		Scanner scan = new Scanner(System.in);
		int yrke = Integer.valueOf(scan.nextLine());
		
		switch (yrke) {
		
		case 1:
			System.out.println("Du har valt pilot, have fun in the air");
			break;
		case 2:
			System.out.println("Du kommer brinna upp");
			break;
		case 3:
			System.out.println("Quack, Quack");
			break;
		case 4:
			System.out.println("Klipp klipp");
			break;
		case 5:
			System.out.println("RIIIIIIIIING");
			break;
		}
	

	}

}
