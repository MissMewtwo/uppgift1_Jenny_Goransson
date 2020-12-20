package atm;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WithdrawPane extends GridPane {

	public WithdrawPane() {
		
		setPadding(new Insets(20, 20, 20, 20));
		setHgap(5);
		setVgap(5);
		
		
		Label amountLabel = new Label("Amount: ");
		TextField amountField = new TextField();
		Button withdraw = new Button("Withdraw");
		Button cancel = new Button("Cancel");
		
		
		add(amountLabel, 0, 0);
		add(amountField, 1, 0);
		add(withdraw, 0, 1);
		add(cancel, 1, 1);
		
		withdraw.setId("login");
		cancel.setId("login");
		
		withdraw.setOnMouseClicked(e -> {
			String amount = amountField.getText();
			// ett saldo
			Boolean didWithdraw = MainATM.activeAccount.calcCheckingWithdraw(Double.parseDouble(amount));
			// ett nytt lr samma saldo
			
			if (didWithdraw) {
			MainATM.toXml();
			
			
			MainATM.currentStage.setScene(new Buttons1());
			} else {
				NewAcc.showAlert(Alert.AlertType.ERROR, MainATM.currentStage.getScene().getWindow(), "Error", "You dont have that amount on your account");
			}
			
		});
		
		cancel.setOnMouseClicked(e -> {
			MainATM.currentStage.setScene(new Buttons1());
		});
	}


}
