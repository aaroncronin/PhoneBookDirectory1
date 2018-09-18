
// NORMALUSER EXTENDS USER CLASS AND IMPLEMENTS OWN INTERFACE
class NormalUser extends User implements Normal {
	
	// NormalUser additionally has id
	private int id;
	
	// establish default constructor with default names to easily determine when used
	public NormalUser() {
		username = "NormalUser";
		password = "NormalPass";
		id = -1;
	}

	// constructor
	public NormalUser(String user, String pass, int idx) {
		username = user;
		password = pass;
		id = idx;

	}

	// override PrintUserInfo method defined in User class
	@Override
	public void PrintUserInfo() {
		System.out.println("ID: " + id + "\nUsername: " + username + "\nPassword: " + password);
	}

}

// normal interface with specific methods
interface Normal {
	
	public int addEntry(PhoneBookEntry entry);
	public int Edit(String firstName, String lastName);
	public void Sort(PhoneBookEntry[] directory);
	public int LinearSearchByPhoneNumber(String PhoneNumber);
	public void PrintUserInfo();
	public void printAllEntries();

}
