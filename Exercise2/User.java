
// establish parent User class
public class User {
	protected String username;
	protected String password;
	protected PhoneBookDirectory phoneBookDirectory = new PhoneBookDirectory();
	
	public PhoneBookEntry[] directory = phoneBookDirectory.directory;
	
	
	
	// default constructor
	public User() {
		this.username = "DefaultUser";
		this.password = "DefaultPassword";
		
	}

	// constructor
	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
		
	}
	
	
	// METHODS COMMON TO BOTH PHONEBOOKADMIN AND NORMALUSER DEFINED IN USER CLASS
	
	// print username and password of user
	public void PrintUserInfo() {
		System.out.println("Username: " + username + "\nPassword: " + password);
	}
	
	// add entry using method defined in PhoneBookDirectory
	public int addEntry(PhoneBookEntry entry) {
		return phoneBookDirectory.addEntry(entry);
	}
	
	// print all entries of directory using method defined in PhoneBookDirectory
	public void printAllEntries() {
		phoneBookDirectory.printAllEntries();
	}
	
	// edit entry using method defined in PhoneBookDirectory
	public int Edit(String firstName, String lastName) {
		return phoneBookDirectory.Edit(firstName, lastName);
	}
	
	// sort directory using method defined in PhoneBookDirectory
	public void Sort(PhoneBookEntry[] directory) {
		phoneBookDirectory.Sort(directory);
		
	}
	
	// linear search by phone number using method defined in PhoneBookDirectory
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		return phoneBookDirectory.LinearSearchByPhoneNumber(PhoneNumber);
	}
	
	
}

