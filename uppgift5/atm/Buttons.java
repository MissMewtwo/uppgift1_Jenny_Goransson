package atm;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Buttons extends GridPane {
	
	public Buttons() {
		
		
		
		Button saldo = new Button("Saldo");
		Button withdraw = new Button("Withdraw");
		Button deposit = new Button("Deposit");
		Button exit = new Button("Exit");
		
		String accountNumber = Integer.toString(MainATM.activeAccount.getAccountNumber());
		
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);
		
		Text text = new Text(accountNumber);
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);
		
		
		setPadding(new Insets(20, 20, 20, 20));
		setHgap(10);
		setVgap(10);
		
		add(text, 0, 0);
		add(saldo, 0, 2);
		add(withdraw, 0, 1);
		add(deposit, 1, 1);
		add(exit, 1, 2);
		
		saldo.setId("login");
		withdraw.setId("login");
		deposit.setId("login");
		exit.setId("login");
		
		exit.setOnMouseClicked(e -> {
			MainATM.currentStage.setScene(new LoginScene());
			MainATM.activeAccount = null;
		});
		
		saldo.setOnMouseClicked(e -> {
			

			NewAcc.showAlert(Alert.AlertType.INFORMATION, MainATM.currentStage.getScene().getWindow(), "Saldo", Double.toString(MainATM.activeAccount.getCheckingBalance()));
			
			
		System.out.println(Double.toString(MainATM.activeAccount.getCheckingBalance()));
			
		});
		
		deposit.setOnMouseClicked(e -> {
			MainATM.currentStage.setScene(new DepositScene());
			
		});
		
		withdraw.setOnMouseClicked(e -> {
			MainATM.currentStage.setScene(new WithdrawScene());
			
		});
	
	}
	
	

}
