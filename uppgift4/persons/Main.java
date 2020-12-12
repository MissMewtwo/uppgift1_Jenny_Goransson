package persons;

import javafx.application.Application;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	
	private TableView<Persons> table = new TableView<Persons>();
	private final ObservableList<Persons> data =
			FXCollections.observableArrayList();
	
	TextField firstNameField;
	TextField lastNameField;
	TextField genderField;
	
	public static final String XML_PATH = "persons";
	
	final HBox hb = new HBox();
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) {
		
		
		Scene scene = new Scene(new Group());
		stage.setTitle("List of interesting People");
		stage.setWidth(450);
		stage.setHeight(550);
		
		final Label label = new Label("List of interesting People");
		label.setFont(new Font("Arial", 20));
		
		
		table.setEditable(true);
		
		
		TableColumn firstName = new TableColumn("First Name");
		firstName.setMinWidth(100);
		firstName.setCellValueFactory(
				new PropertyValueFactory<Persons, String>("firstName"));
		firstName.setCellFactory(TextFieldTableCell.forTableColumn());
		firstName.setOnEditCommit(
				new EventHandler<CellEditEvent<Persons, String>>() {
					@Override
					public void handle(CellEditEvent<Persons, String> t) {
						((Persons) t.getTableView().getItems().get(t.getTablePosition().getRow())
								).setFirstName(t.getNewValue());
					}
				});
		
	    TableColumn lastName = new TableColumn("Last Name");
	    lastName.setMinWidth(100);
	    lastName.setCellValueFactory(
	    		new PropertyValueFactory<Persons, String>("lastName"));
	   lastName.setCellFactory(TextFieldTableCell.forTableColumn());
	   lastName.setOnEditCommit(
			   new EventHandler<CellEditEvent<Persons, String>>() {
				   @Override
				   public void handle(CellEditEvent<Persons, String> t) {
					   ((Persons) t.getTableView().getItems().get(t.getTablePosition().getRow())
							   ).setLastName(t.getNewValue());
				   }
			   });
	   
	   TableColumn gender = new TableColumn("Gender");
	   gender.setMinWidth(100);
	   gender.setCellValueFactory(
			   new PropertyValueFactory<Persons, String>("Gender"));
	   gender.setCellFactory(TextFieldTableCell.forTableColumn());
	   gender.setOnEditCommit(
			   new EventHandler<CellEditEvent<Persons, String>>() {
				   @Override
				   public void handle(CellEditEvent<Persons, String> t) {
					   ((Persons) t.getTableView().getItems().get(t.getTablePosition().getRow())
							   ).setGender(t.getNewValue());
				   }
			   });
	 
	    table.setItems(data);
	   	table.getColumns().addAll(firstName, lastName, gender);
	   
	    firstNameField = new TextField();
	    firstNameField.setPromptText("First Name");
	    firstNameField.setMaxWidth(firstName.getPrefWidth());
	    lastNameField = new TextField();
	    lastNameField.setPromptText("Last Name");
	    lastNameField.setMaxWidth(lastName.getPrefWidth());
	    genderField = new TextField();
	    genderField.setPromptText("Gender");
	    genderField.setMaxWidth(gender.getPrefWidth());
	    
	    final Button addButton = new Button("Add");
	    addButton.setOnAction(e -> addCode(e));
	    
	    final Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteCode(e));
		
		
		readXml();
		
		hb.getChildren().addAll(firstNameField, lastNameField, genderField, addButton, deleteButton);
		hb.setSpacing(3);
		
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, hb);
		
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	
	
	
	
	

	
	
	
	public void addCode(ActionEvent e) {
		
		
		data.add(new Persons(
				firstNameField.getText(),
				lastNameField.getText(),
				genderField.getText()));
		
		
		firstNameField.clear();
		lastNameField.clear();
		genderField.clear();
		
		
		toXml();
		
	}
	
	public void deleteCode(ActionEvent e) {
		Persons selectedItem = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(selectedItem);
		
	}
	
	
	private void toXml() {
		
		XMLEncoder encoder = null;
		
		try {
			encoder = new XMLEncoder (new BufferedOutputStream(new
					FileOutputStream(XML_PATH)));
			System.out.println("File stream opened and XMLEncoder created");
			
		} catch (FileNotFoundException filenNotFound) {
			System.out.println("ERROR: While Creating or Opening the file persons.xml");
		}
		encoder.writeObject(data.toArray());
		encoder.close();
	}

	
	public void readXml() {
		
		XMLDecoder decoder = null;
		
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new
					FileInputStream(XML_PATH)));
			System.out.println("File stream opened and XMLDecoder created");
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: File persons.xml not found");
		}
		
		Object[] objects = (Object[]) decoder.readObject();
		for (Object object : objects)
			data.add((Persons)object);
		decoder.close();
	}
	
}
