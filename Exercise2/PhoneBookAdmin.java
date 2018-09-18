
// PHONEBOOKADMIN EXTENDS USER CLASS AND IMPLEMENTS OWN INTERFACE
class PhoneBookAdmin extends User implements Admin {
	// PhoneBookAdmin additionally has email address
	private String emailAddress;
	
	// establish default constructor with default names to easily determine when used
	public PhoneBookAdmin() {
		username = "AdminUser";
		password = "AdminPass";
		emailAddress = "AdminEmail";
	}
	
	// constructor
	public PhoneBookAdmin(String user, String pass, String email) {
		username = user;
		password = pass;
		emailAddress = email;
	}

	// METHODS SPECIFIC TO PHONEBOOKADMIN CLASS
	
	// delete entry by ID using method defined in PhoneBookDirectory
	public int DeleteEntry(int id) {
		return phoneBookDirectory.DeleteEntry(id);
	}
	
	// search directory by ID using method defined in PhoneBookDirectory
	public PhoneBookEntry SearchByIdBinarySearch(int id) {
		return phoneBookDirectory.SearchByIdBinarySearch(id);
	}
	
	// override PrintUserInfo method defined in User class
	@Override
	public void PrintUserInfo() {
		System.out.println("Username: " + username + "\nPassword: " + password + "\nEmail: " + emailAddress);
	}
	
	// method that allows admin to change their username
	public void changeUsername(String user) {
		username = user;
	}
	
	// method that allows admin to chagne their password
	public void changePassword(String pass) {
		password = pass;
	}
	
}

//admin interface with specific methods
interface Admin {
	
	public int addEntry(PhoneBookEntry entry);
	public int Edit(String firstName, String lastName);
	public int DeleteEntry(int id);
	public void Sort(PhoneBookEntry[] directory);
	public int LinearSearchByPhoneNumber(String PhoneNumber);
	public PhoneBookEntry SearchByIdBinarySearch(int id);
	public void printAllEntries();
	public void PrintUserInfo();
	public void changeUsername(String user);
	public void changePassword(String pass);
	
}
