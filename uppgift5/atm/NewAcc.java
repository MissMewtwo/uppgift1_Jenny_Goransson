package atm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import persons.Persons;

public class NewAcc extends GridPane {
	
	
	public NewAcc() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(40, 40, 40, 40));
		setHgap(10);
		setVgap(10);
	
	
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);
		
		ColumnConstraints columnTwoConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
		columnTwoConstraints.setHgrow(Priority.ALWAYS);
		
		getColumnConstraints().addAll(columnOneConstraints, columnTwoConstraints);
		
		addUIControls(this);
	}
	
	private void addUIControls(GridPane gridPane) {
		
		Label headerLabel = new Label("Registration Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
		
		Label nameLabel = new Label("Full Name ");
		gridPane.add(nameLabel, 0, 1);
		
		TextField nameField = new TextField();
		nameField.setPrefHeight(40);
		gridPane.add(nameField, 1, 1);
		
		Label homeAdress = new Label("HomeAdress: ");
		gridPane.add(homeAdress, 0, 2);
		
		TextField adressField = new TextField();
		adressField.setPrefHeight(40);
		gridPane.add(adressField, 1, 2);
		
		Label userLabel = new Label("Username: ");
		gridPane.add(userLabel, 0, 3);
		
		TextField userField = new TextField();
		userField.setPrefHeight(40);
		gridPane.add(userField, 1, 3);
		
		Label pincodeLabel = new Label("Pincode: ");
		gridPane.add(pincodeLabel, 0, 4);
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(40);
		gridPane.add(passwordField, 1, 4);
		
		Label depositLabel = new Label("Deposit: ");
		gridPane.add(depositLabel, 0, 5);
		
		TextField depositField = new TextField();
		depositField.setPrefHeight(40);
		gridPane.add(depositField, 1, 5);
		
		
		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(40);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(100);
		gridPane.add(submitButton, 0, 6, 2, 1);
		GridPane.setHalignment(submitButton, HPos.CENTER);
		GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
		
		submitButton.setId("submit");
		
		submitButton.setOnMouseClicked(e -> {
			
			if(nameField.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Name");
				return;
			}
			
			if(adressField.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),"Form Error!", "Please enter your adress");
				return;
			}
			
			if(passwordField.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a pincode");
				return;
			}
			
			if(depositField.getText().isEmpty()) {
				showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter an amount to Deposit");
				return;
			}
			
			showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successfull!", "Welcome to the ATM Bank");

			String number = "";
			for (int i = 0; i < 2; i++)
				number += 1000 + Math.round(Math.random() * 8999);

			MainATM.data.add(new Accounts(
					nameField.getText(),
					adressField.getText(),
					userField.getText(),
					Integer.parseInt(passwordField.getText()),
					Double.parseDouble(depositField.getText()),
					Integer.parseInt(number)));
			
			MainATM.toXml();
			
			MainATM.currentStage.setScene(new LoginScene());
		});
		
	}
	
	public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
	
	
		

}
