package atm;

import javafx.scene.Scene;

public class WithdrawScene extends Scene {
	
	public WithdrawScene() {
		
		
		super(new WithdrawPane());
		
		getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	}

}
