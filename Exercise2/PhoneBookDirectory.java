import java.util.Scanner;
public class PhoneBookDirectory {
	
	public PhoneBookEntry[] directory;
	int count = 0;
	
	public PhoneBookDirectory() {
		directory = new PhoneBookEntry[6];
		for (int i = 0; i < directory.length; i++)
			directory[i] = new PhoneBookEntry();
		
	}
	

	// add entries until directory reaches max size
	public int addEntry(PhoneBookEntry entry) {
		if (count < directory.length) {
			for (int i = 0; i < directory.length; i++) {
				if (directory[i].getID() == -1) {
					directory[i] = entry;
					count++;
					return 1;
				}
			}
		}
		return 0;
			
	}
	
	// print all entries
	public void printAllEntries() {
		System.out.println("These are the current listings in the directory: ");
		for (int i = 1; i < count+1; i++) {
			System.out.println("ENTRY " + i + ": " + directory[i-1]);
		}
	}
	
	// linear search by phone number, see if parameter matches phone number in directory
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		for (int i = 0; i < directory.length; i++) {
			if (PhoneNumber.equals(directory[i].getPhoneNumber())) 
				return 1;		
		}
		return 0;
	}
	
	public PhoneBookEntry SearchByIdBinarySearch(int id) {
		// sort the directory using Sort method that implements compareTo
		// necessary for binary search
		Sort(directory);
		int low = 0;
		int high = count - 1;
		int mid;
		
		// continuously cut results in half
		while (low <= high) {
			mid = (low + high)/2;
			if (id < directory[mid].getID())
				high = mid - 1;
			else if (id == directory[mid].getID())
				return directory[mid];
			else
				low = mid + 1;
		}
		
		// return default entry if id is not found
		PhoneBookEntry empty = new PhoneBookEntry();
		return empty;

	}
	
	// sort the directory entries by ID
	// use compareTo method defined in parent PhoneBookEntry class
	public void Sort(PhoneBookEntry[] directory) {
		int test;
		PhoneBookEntry currentMinEntry;
		int currentMinIndex;
		
		
		// establish first entry as the minimum
		for (int i = 0; i < count; i++) {
			
			currentMinIndex = i;
			currentMinEntry = directory[i];
			
			// calling compareTo method
			// test if succeeding ID is less than previous one
			for (int j = i+1; j < count; j++) {
				test = directory[i].compareTo(directory[j]);
				if (test == 1) {
					currentMinEntry = directory[j];
					currentMinIndex = j;
				}	
			}
			if (currentMinIndex != i) {
				directory[currentMinIndex] = directory[i];
				directory[i] = currentMinEntry;
			}
			
		}
	}
	
	public int Edit(String firstName, String lastName) {
		String replace;
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < directory.length; i++) {
			if (firstName.equals(directory[i].getFirstName()) && lastName.equals(directory[i].getLastName())) {
				
				// do while loop while user is editing all attributes they want
				// call chooseEdit method that lets user choose which attributes they want to change
				do { 
					switch (chooseEdit()) {
					case 1:
						System.out.print("Enter new ID number: ");
						int replaceID = input.nextInt();
						directory[i].setID(replaceID);
						break;
					case 2:
						System.out.print("Enter new First Name: ");
						replace = input.next();
						directory[i].setFirstName(replace);
						break;
					case 3:
						System.out.print("Enter new Last Name: ");
						replace = input.next();
						directory[i].setLastName(replace);
						break;
					case 4:
						System.out.print("Enter new Email: ");
						replace = input.next();
						directory[i].setEmail(replace);	
						break;
					case 5:
						System.out.print("Enter new Zip Code: ");
						replace = input.next();
						directory[i].setZipCode(replace);
						break;
					case 6:
						System.out.print("Enter new Phone Number: ");
						replace = input.next();
						directory[i].setPhoneNumber(replace);
						break;
					}
				} while (chooseEdit() != 7);
				return 1;
			}
		}
		return 0;
		
	}
	
	// method that lets user choose which attribute they want to edit
	public int chooseEdit() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of the attribute you would like to edit: ");
		System.out.println("1. ID");
		System.out.println("2. First Name");
		System.out.println("3. Last Name");
		System.out.println("4. Email");
		System.out.println("5. Zip Code");
		System.out.println("6. Phone Number");
		System.out.println("7. Stop Editting");
		int choice = input.nextInt();
		
		return choice;
		
	}
	
	// if ID found, set entry to default entry
	public int DeleteEntry(int id) {
		PhoneBookEntry temp;
		for (int i = 0; i < directory.length; i++) {
			if (id == directory[i].getID()) {
				directory[i] = new PhoneBookEntry();
				temp = directory[i];
				directory[i] = directory[i+1];
				directory[i+1] = temp;
				// directory[i] = new PhoneBookEntry();
				// directory[i+1] = directory[i];
				count--;
				return 1;
			}
		}
		return 0;
	}
}