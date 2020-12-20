package atm;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DepositPane extends GridPane {
	
	public DepositPane() {
		
		setPadding(new Insets(20, 20, 20, 20));
		setHgap(5);
		setVgap(5);
		
		
		Label amountLabel = new Label("Amount: ");
		TextField amountField = new TextField();
		Button deposit = new Button("Deposit");
		Button cancel = new Button("Cancel");
		
		
		add(amountLabel, 0, 0);
		add(amountField, 1, 0);
		add(deposit, 0, 1);
		add(cancel, 1, 1);
		
		deposit.setId("login");
		cancel.setId("login");
		
		deposit.setOnMouseClicked(e -> {
			String amount = amountField.getText();
			MainATM.activeAccount.calcCheckingDeposit(Double.parseDouble(amount));

			MainATM.toXml();
			
			MainATM.currentStage.setScene(new Buttons1());
			
			
		});
		
		cancel.setOnMouseClicked(e -> {
			MainATM.currentStage.setScene(new Buttons1());
		});
	}

}
