
public class PhoneBookEntry implements Comparable<PhoneBookEntry> {

	// member variables
	private int Id;
	private String firstName;
	private String lastName;
	private String email;
	private String zipCode;
	private String phoneNumber;
	
	// default values 
	// id defaults to -1, rest are labeled as default to confirm they are default
	public PhoneBookEntry() {
		this.Id = -1;
		this.firstName = "defaultFN";
		this.lastName = "defaultLN";
		this.email = "defaultEMAIL";
		this.zipCode = "defaultZIP";
		this.phoneNumber = "defaultNUM";
		
	}
	
	// entry with just a first name
	public PhoneBookEntry(String fn) {
		firstName = fn;
	}
	
	// entry with first name and phone number
	public PhoneBookEntry(String fn, String num) {
		firstName = fn;
		phoneNumber = num;
	}
 	
	// entry with all attributes
	public PhoneBookEntry(int id, String fn, String ln, String eml, String zip, String num) {
		this.Id = id;
		this.firstName = fn;
		this.lastName = ln;
		this.email = eml;
		this.zipCode = zip;
		this.phoneNumber = num;
		
	}
	
	// getters and setters
	public int getID() {
		return Id;
	}
	
	public void setID(int id) {
		this.Id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String fn) {
		this.firstName = fn;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String eml) {
		this.email = eml;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zip) {
		this.zipCode = zip;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String num) {
		this.phoneNumber = num;
	}
	
	// print the entry
	public void printBookEntry() {
		System.out.println("ID: " + Id + "\nFirst Name:" + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\nZip Code: " + zipCode + "\nPhone Number: " + phoneNumber);
	}
	
	/*
	public int compare(PhoneBookEntry x, PhoneBookEntry o) {
		if (x == null && o == null)
			return 0;
		return x.compareTo(o);
	}
	*/
	
	// implement compareTo method from Comparable
	@Override
	public int compareTo(PhoneBookEntry o) {
		
		PhoneBookEntry entry = new PhoneBookEntry();
		entry = (PhoneBookEntry) o;
		
		if (this.getID() == -1 || entry.getID() == -1)
			return 0;
		else if (this.getID() > entry.getID())
			return 1;
		else if (this.getID() < entry.getID())
			return -1;
		return 0;
	}
	
	
	@Override
	public String toString() {
		return this.Id + " " + this.firstName + " " + this.lastName + " " + this.email + " " + this.zipCode + " " + this.phoneNumber;
	
	}
	
}
