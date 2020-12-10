package stopp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import stopp.DateTime;

public class StoppKlocka extends Application {
	
	Button startButton;
	Button resetButton;
	Button clearButton;
	Text time;
	Circle circle;
	Circle circle2;
	Timeline clock;
	@SuppressWarnings("rawtypes")
	TableView tableView;
	String stopTime;
	int mili = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void start(Stage primaryStage) {
		
		startButton = new Button("Start");
		resetButton = new Button("Reset");
		clearButton = new Button("Clar");
		time = new Text("00:00:00:000");
		circle = new Circle();
		circle2 = new Circle();
		tableView = new TableView();
		
		TableColumn<DateTime, String> column1 = new TableColumn<>("Date Time");
	    column1.setCellValueFactory(new PropertyValueFactory<>("dateTime"));


	    TableColumn<DateTime, String> column2 = new TableColumn<>("Time");
	    column2.setCellValueFactory(new PropertyValueFactory<>("stopTime"));
	    
	    tableView.getColumns().add(column1);
	    tableView.getColumns().add(column2);
		
		
		clock = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent e) {
				update(time);
			}
			
		}));
		
		clock.setCycleCount(Timeline.INDEFINITE);
		clock.setAutoReverse(false);
		
		circle.setCenterX(0.0f);
		circle.setCenterY(0.0f);
		circle.setRadius(28.0f);
		circle.setFill(Color.TRANSPARENT);
		circle.setStroke(Color.valueOf("#404040"));
		circle.setStrokeWidth(2);
		
		circle2.setCenterX(0.0f);
		circle2.setCenterY(0.0f);
		circle2.setRadius(28.0f);
		circle2.setFill(Color.TRANSPARENT);
		circle2.setStroke(Color.valueOf("#0A2611"));
		circle2.setStrokeWidth(2);
		
		startButton.setStyle("-fx-background-radius: 5em;" + "-fx-min-width: 50px;" +
				"-fx-min-height: 50px;" + "-fx-max-width: 50px;" + "-fx-max-height: 50px;" +
				"-fx-background-color: #0A2611;" + "-fx-text-fill: #18732F;");
		resetButton.setStyle("-fx-background-radius: 5em;" + "-fx-min-width: 50px;" +
				"-fx-min-height: 50px;" + "-fx-max-width: 50px;" + "-fx-max-height: 50px;" +
				"-fx-background-color: #404040;" + "-fx-text-fill: white;");
		clearButton.setStyle("-fx-background-radius: 5em;" + "-fx-min-width: 50px;" +
				"-fx-min-height: 50px;" + "-fx-max-width: 50px;" + "-fx-max-height: 50px;" +
				"-fx-background-color: #404040;" + "-fx-text-fill: white;");
		tableView.setStyle("-fx-min-width: 200px;" + "-fx-min-height: 200px;" + "-fx-max-width: 200px;" + 
				"-fx-max-height: 200px;" + "-fx-background-color: #000000");
		
		time.setStyle("-fx-font: 32px Tahoma;");
		time.setFill(Color.WHITE);
		

		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		
		root.setHgap(100);
		root.setVgap(50);
		
		root.add(circle, 0, 1);
		root.add(circle2, 1, 1);
		root.add(startButton, 1, 1);
		root.add(resetButton, 0, 1);
		root.add(clearButton, 0, 6);
		root.add(time, 0, 0, 2, 1);
		root.add(tableView, 0, 2, 2, 4);
		
		
		
		
		GridPane.setMargin(circle, new Insets(1, 0, 0, -4));
		GridPane.setMargin(circle2, new Insets(1, 0, 0, -4));
		
		setWidths();
		
		Scene scene = new Scene(root, 300, 500);
		
		root.setStyle("-fx-background-color: #000000;");
		
		primaryStage.setTitle("StopWatch");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		startButton.setOnAction(e -> startCode(e));
		resetButton.setOnAction(e -> resetCode(e));
		clearButton.setOnAction(e -> clearCode(e));
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void setWidths() {
		startButton.setPrefWidth(50);
		resetButton.setPrefWidth(50);
	}
	
	public void startCode(ActionEvent e) {
		clock.play();
		startButton.setText("Stop");
		startButton.setOnAction(e2 -> startAgain(e2));
		startButton.setStyle("-fx-background-radius: 5em;" + "-fx-min-width: 50px;" +
				"-fx-min-height: 50px;" + "-fx-max-width: 50px;" + "-fx-max-height: 50px;" +
				"-fx-background-color: #4A0409;" + "-fx-text-fill: #FF0000;");
		circle2.setStroke(Color.valueOf("#4A0409"));
	}
	
	
	
	public void startAgain(ActionEvent e2) {
		clock.pause();
		setTable();
		startButton.setText("Start");
		startButton.setOnAction(e -> startCode(e));
		startButton.setStyle("-fx-background-radius: 5em;" + "-fx-min-width: 50px;" +
				"-fx-min-height: 50px;" + "-fx-max-width: 50px;" + "-fx-max-height: 50px;" +
				"-fx-background-color: #0A2611;" + "-fx-text-fill: #18732F;");
		circle2.setStroke(Color.valueOf("#0a2611"));
		
		
	}
	
	public void resetCode(ActionEvent e) {
		clock.stop();
		mili = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		time.setText("00:00:00:000");
		
	}
	
	public void clearCode(ActionEvent e) {
		tableView.getItems().clear();
	}
	
	void update(Text time) {
		if(mili == 1000) {
			seconds++;
			mili = 0;
			
		}
		
		if(seconds == 60) {
			minutes++;
			seconds = 0;
		}
		
		if(minutes == 60) {
			hours++;
			minutes = 0;
		}
		
		time.setText(hours + ":" +(((minutes/10) == 0) ? "0": "") + minutes + ":" + 
				(((seconds/10) == 0) ? "0" : "") + seconds + ":" +
				(((mili/10) == 0) ? "00" : (((mili/100) == 0) ? "0" : "")) + mili++);
		
		stopTime = hours + ":" + minutes + ":" + seconds + ":" + mili;
	}
	
	
	
	public void setTable() {
	
	
    
    DateTime dateStop = new DateTime();
	dateStop.setDateTime();
	dateStop.setStopTime(stopTime);
	
	tableView.getItems().addAll(dateStop);
    
    
    
    
	}

}

