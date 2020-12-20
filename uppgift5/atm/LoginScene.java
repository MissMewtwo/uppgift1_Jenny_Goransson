package atm;

import javafx.scene.Scene;

public class LoginScene extends Scene {
	
	public LoginScene() {
		super(new LoginPane());
		
		getStylesheets().add(getClass().getResource("login.css").toExternalForm());
	}

}
