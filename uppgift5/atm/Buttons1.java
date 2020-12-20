package atm;


import javafx.scene.Scene;

public class Buttons1 extends Scene {
	
	public Buttons1() {
		super(new Buttons());
		
		
		getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	}

}
