package persons;

import javafx.beans.property.SimpleStringProperty;

public class Persons {
	
	private final SimpleStringProperty firstName = new SimpleStringProperty();
	private final SimpleStringProperty lastName = new SimpleStringProperty();
	private final SimpleStringProperty gender = new SimpleStringProperty();
	
	public Persons() {}
		
	
	
	
	public Persons (String fName, String lName, String gen) {
		setFirstName(fName);
		setLastName(lName);
		setGender(gen);
		
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(String fName) {
		firstName.set(fName);
	}
	
	public String getLastName() {
		return lastName.get();
	}
	
	public void setLastName(String lName) {
		lastName.set(lName);
	}
	
	public String getGender() {
		return gender.get();
	}
	
	public void setGender(String gen) {
		gender.set(gen);
	}
	

	
	


}
