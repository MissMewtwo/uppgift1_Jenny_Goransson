package atm;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginPane extends BorderPane {
	
	String checkUser, checkPw;
	
	public LoginPane() {
		setPadding(new Insets(10, 50, 50, 50));
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 20, 30));
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		
		
		Label account = new Label("UserName");
		final TextField txtAccount = new TextField();
		Label pinNumber = new Label("PinNumber");
		final PasswordField pf = new PasswordField();
		Button login = new Button("Login");
		Button create = new Button("Create Acc");
		final Label lblMessage = new Label();
		
		gridPane.add(account, 0, 0);
		gridPane.add(txtAccount, 1, 0);
		gridPane.add(pinNumber, 0, 1);
		gridPane.add(pf, 1, 1);
		gridPane.add(login, 2, 1);
		gridPane.add(create, 2, 2);
		gridPane.add(lblMessage, 1, 2);
		
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		gridPane.setEffect(r);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);
		
		
		Text text = new Text("ATM Login");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);
		
		hb.getChildren().add(text);
		
		setId("bp");
		gridPane.setId("root");
		login.setId("login");
		create.setId("create");
		text.setId("text");
		
		
		login.setOnMouseClicked(e -> {
			
			checkUser = txtAccount.getText();
			checkPw = pf.getText();
			
				for (Accounts accounts : MainATM.data) {
					MainATM.activeAccount = accounts;
					String username = accounts.getUser();
					String password = String.valueOf(accounts.getPinNumber());
					
					if(checkUser.equals(username) && checkPw.equals(password)) {
						lblMessage.setText("Welcome");
						lblMessage.setTextFill(Color.GREEN);
						MainATM.currentStage.setScene(new Buttons1());
						
						
						return;
					} 
						lblMessage.setText("Incorrect Account or Pin");
						lblMessage.setTextFill(Color.RED);
					
				}
				
			
				account.setText("");
				pf.setText("");
			

			
				
			
		});
		
		create.setOnMouseClicked(e -> {
			
			MainATM.currentStage.setScene(new NewAcc1());
			
		});
		
		
		setTop(hb);
		setCenter(gridPane);
		
		
		
//		primaryStage.setScene(scene);
//		primaryStage.titleProperty().bind(
//				scene.widthProperty().asString().
//				concat(" : ").
//				concat(scene.heightProperty().asString()));
		
		//primaryStage.show();
	}
	
	

}
