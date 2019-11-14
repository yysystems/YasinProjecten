package bankaccountapp;

public class Savings extends Account {

	
	// list properties specific to a Checking account
	private int safetyDepositBoxKey;
	private int safetyDepositBoxID;
	
	
	
	// Constructor to initialize settings for the Savings properties

	public Savings(String name, String sSN, double initDeposit) {
		super( name,  sSN,  initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
		
	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;	}
	
	// List any methods specific to the savings account

	public void showInfo() {
		super.showInfo();
		System.out.println(
				"\nYour Savings Account Features"
				+ "\n Safety Deposti Box ID: " + safetyDepositBoxID +
				"\n Safety Deposit Box Key: " + safetyDepositBoxKey
				
				
				
				);
	}
	
	
	
}