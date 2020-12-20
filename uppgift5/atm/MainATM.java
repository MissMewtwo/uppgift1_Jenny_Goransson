package atm;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.stage.Stage;
import persons.Persons;


public class MainATM extends Application {
	
	public static ObservableList<Accounts> data =
			FXCollections.observableArrayList();
	
	static Accounts activeAccount;
	static Stage currentStage;
	
	public static final String XML_PATH = "accounts";
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ATM");
		
		currentStage = primaryStage;

		readXml();
		
		
		Scene scene = new LoginScene();
		scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.titleProperty().bind(
				scene.widthProperty().asString().
				concat(" : ").
				concat(scene.heightProperty().asString()));
		
		primaryStage.show();
	}
	
public static void toXml() {
		XMLEncoder encoder = null;
		
		try {
			encoder = new XMLEncoder (new BufferedOutputStream(new
					FileOutputStream(XML_PATH)));
			System.out.println("File stream opened and XMLEncoder created");
			
			encoder.writeObject(data.toArray());
			encoder.close();
			
		} catch (FileNotFoundException filenNotFound) {
			System.out.println("ERROR: While Creating or Opening the file persons.xml");
		}
	}


	
public void readXml() {
	
	XMLDecoder decoder = null;
	
	try {
		decoder = new XMLDecoder(new BufferedInputStream(new
				FileInputStream(XML_PATH)));
		System.out.println("File stream opened and XMLDecoder created");
		
		Object[] objects = (Object[]) decoder.readObject();
		for (Object object : objects)
			data.add((Accounts)object);
		decoder.close();
		
	} catch (FileNotFoundException e) {
		System.out.println("Error: File accounts.xml not found");
	}
	
	
}

}
