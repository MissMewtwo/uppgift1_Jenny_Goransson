package atm;

import javafx.scene.Scene;

public class NewAcc1 extends Scene {
	
	public NewAcc1() {
		super(new NewAcc(), 800, 500);
		getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	}

}
