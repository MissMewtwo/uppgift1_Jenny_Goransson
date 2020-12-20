package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Accounts {
	
	private int accountNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private String name;
	private String adress;
	private String user;
	private LocalDateTime now = LocalDateTime.now();
	private DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	public Accounts() {	
	}
	
	public Accounts(String name, String adress, String user, int password, double checkingBalance, int accountNumber) {
		setName(name);
		setAdress(adress);
		setUser(user);
		setPinNumber(password);
		setCheckingBalance(checkingBalance);
		setAccountNumber(accountNumber);
		
		this.now = LocalDateTime.now();
	}
	
	
	
	
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
		
	}
	
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		
	}
	
	public int getPinNumber() {
		return pinNumber;
	}
	
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
		
	}
	
	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	
	public Boolean calcCheckingWithdraw(double amount) {
		if(amount <= checkingBalance) {
			checkingBalance = (checkingBalance - amount);
			return true;
		
		}
		return false;
		
		
		
	}
	
	
	
	
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	public LocalDateTime getNow() {
		return now;
	}


	public void setNow(LocalDateTime now) {
		this.now = now;
	}
	
	
	
	
	

}
