package atm;

import javafx.scene.Scene;

public class DepositScene extends Scene {
	
	public DepositScene() {
		super(new DepositPane());
		
		getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	}

}
