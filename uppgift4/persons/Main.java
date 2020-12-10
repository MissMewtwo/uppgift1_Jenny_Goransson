package persons;

import javafx.application.Application;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	
	TableView<Persons> table = new TableView<Persons>();
	
	
	TextField firstName;
	TextField lastName;
	TextField age;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		primaryStage.setTitle("Personhantering");
		
		table.setEditable(true);
		
		
		TableColumn<Persons, String> column1 = new TableColumn<>("First Name");
	    column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	    column1.setEditable(true);
	    column1.setOnEditCommit(new EventHandler<CellEditEvent<Persons, String>>() {
	        @Override
	        public void handle(CellEditEvent<Persons, String> t) {
	        	System.out.println("Test");
	            ((Persons) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
	        }
	    });
	   
	   // column1.setOnEditCommit((CellEditEvent<Persons, String>event)-> {
	    	//TablePosition<Persons, String> pos = event.getTablePosition();
	    		
//	    	String newFirstName = event.getNewValue();
//	    	
//	    	int row = pos.getRow();
//	    	Persons person = event.getTableView().getItems().get(row);
//	    	
//	    	person.setFirstName(newFirstName);
	    //});
	    
	    


	    TableColumn<Persons, String> column2 = new TableColumn<>("Last Name");
	    column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	    
	    TableColumn<Persons, String> column3 = new TableColumn<>("Age");
	    column3.setCellValueFactory(new PropertyValueFactory<>("age"));
	    
	    table.getColumns().addAll(column1, column2, column3);
	    
	    
	    table.setStyle("-fx-min-width: 250px;" + "-fx-min-height: 250px;" + "-fx-max-width: 250px;" + 
				"-fx-max-height: 250px;");
	    
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(3);
		grid.setHgap(1);
		
		GridPane.setConstraints(table, 0, 10);
		grid.getChildren().add(table);
		
		Label fName = new Label("First Name:");
		GridPane.setConstraints(fName, 0, 0);
		grid.getChildren().add(fName);
		
		firstName = new TextField();
		firstName.setPrefColumnCount(10);
		firstName.getText();
		GridPane.setConstraints(firstName, 1, 0);
		grid.getChildren().add(firstName);
		
		Label lName = new Label("Last Name:");
		GridPane.setConstraints(lName, 0, 1);
		grid.getChildren().add(lName);
		
		lastName = new TextField();
		GridPane.setConstraints(lastName, 1, 1);
		grid.getChildren().add(lastName);
		
		Label labelAge = new Label("Age:");
		GridPane.setConstraints(labelAge, 0, 2);
		grid.getChildren().add(labelAge);
		
		age = new TextField();
		GridPane.setConstraints(age, 1, 2);
		grid.getChildren().add(age);
		
		
		Button add = new Button("Add");
		GridPane.setConstraints(add, 0, 3);
		grid.getChildren().add(add);
		
		Button update = new Button("Update");
		GridPane.setConstraints(update, 1,3);
		grid.getChildren().add(update);
		
		Button delete = new Button("Delete");
		GridPane.setConstraints(delete, 2, 3);
		grid.getChildren().add(delete);
		
		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		add.setOnAction(e -> addCode(e));
		//delete.setOnAction(e -> deleteCode(e));
		//update.setOnAction(e -> updateCode(e));
		
		readXml();
		
	}
	
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	

	
	
	
	public void addCode(ActionEvent e) {
		
		Persons info = new Persons();
		info.setFirstName(firstName.getText());
		info.setLastName(lastName.getText());
		info.setAge(Integer.valueOf(age.getText()));
		
		firstName.clear();
		lastName.clear();
		age.clear();
		table.getItems().addAll(info);
		
		toXml();
		
	}
	
	public void deleteCode(ActionEvent e) {
		
		
	}
	
	
	private void toXml() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = dbFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Persons");
			doc.appendChild(rootElement);
			ObservableList<Persons> personArray = table.getItems();
			
			
			for (int i=0; i<personArray.size(); i++) {
				Persons personData = personArray.get(i);
				
				Element person = doc.createElement("Person");
				
				person.setAttribute("firstName", personData.getFirstName());
				person.setAttribute("lastName", personData.getLastName());
				person.setAttribute("age", personData.getAge().toString());
				
				rootElement.appendChild(person);
				
				
				
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("/Users/jennygoransson/personer.xml"));
			transformer.transform(source,  result);
			
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readXml() {
		try {
			File file = new File("/Users/jennygoransson/personer.xml");
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nodeList = doc.getElementsByTagName("Person");
			
			for(int i = 0; i<nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				NamedNodeMap nodeAttributes = node.getAttributes();
				String firstName = nodeAttributes.getNamedItem("firstName").getNodeValue();
				String lastName = nodeAttributes.getNamedItem("lastName").getNodeValue();
				String age = nodeAttributes.getNamedItem("age").getNodeValue();
				Persons info = new Persons();
				info.setFirstName(firstName);
				info.setLastName(lastName);
				info.setAge(Integer.valueOf(age));
				
				table.getItems().addAll(info);
				
			}
			
		} catch (Exception e) {
			
		}
	}
	
	
	
	
	
	
}
