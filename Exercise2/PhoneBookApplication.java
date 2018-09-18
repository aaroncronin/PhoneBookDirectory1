import java.util.Scanner;
import java.io.*;
public class PhoneBookApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		// ADMIN USERNAME AND PASSWORD: ac6296 419beacon
		// NORMAL USERNAME AND PASSWORD: aaron cronin
		
		File file = new File("users.txt");
		Scanner readFile = new Scanner(file).useDelimiter(",");
		
		String username1, username2, password1, password2, emailx;
		int idx;
		
		// get usernames and password for each, email for admin, id for normal
		
	
			// first user
			username1 = readFile.next();
			password1 = readFile.next();
			emailx = readFile.next();
			
			// second user
			username2 = readFile.next();
			password2 = readFile.next();
			idx = readFile.nextInt();
			
			readFile.close();
		
	
		int choice;
		
		PhoneBookAdmin Admin = new PhoneBookAdmin(username1, password1, emailx);
		
		NormalUser Normal = new NormalUser(username2, password2, idx);
		
		System.out.println("Hi, Welcome to the Phone Book!");
		System.out.println("Please enter your login information.");
		System.out.print("Username: ");
		String username = input.next();
		System.out.print("Password: ");
		String password = input.next();
		
		
		
		if (username.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("Welcome Admin! Enter the number of what you would like to do!");
			
			do {
				
			System.out.println("1. Add Entry \n2. Edit Entry \n3. Delete Entry \n4. Sort Directory \n5: Search by Phone Number \n6: Search by ID \n7: Print all Entries in Directory \n8. Print User Info \n9. Change Username \n10. Change Password \n0. Quit");
			choice = input.nextInt();
			
			switch (choice) {
			
			
			// add entry
			case 1: 
				System.out.print("Enter ID: "); int id = input.nextInt();
				System.out.print("Enter First Name: "); String fn = input.next();
				System.out.print("Enter Last Name: "); String ln = input.next();
				System.out.print("Enter Email Address: "); String email = input.next();
				System.out.print("Enter Zip Code: "); String zip = input.next();
				System.out.print("Enter Phone Number: "); String num = input.next();
				PhoneBookEntry entry = new PhoneBookEntry(id, fn, ln, email, zip, num);
				if (Admin.addEntry(entry) == 1) {
					System.out.println("Succesfully added!");
				}
				else
					System.out.println("Directory is full! Couldn't add!");
				break;
			
			// edit entry
			case 2:
				if (Admin.phoneBookDirectory.count > 0) {
					System.out.print("Enter First Name: "); String fn1 = input.next();
					System.out.print("Enter Last Name: "); String ln2 = input.next();
					
					if (Admin.Edit(fn1, ln2) == 1)
						System.out.println("Succesfully editted!");
					else
						System.out.println("Couldn't edit.");
				}
				else 
					System.out.println("Need at least one entry to edit.");
				break;
				
			// delete entry by id	
			case 3:
				if (Admin.phoneBookDirectory.count > 0) {
					System.out.print("Enter ID: "); int id1 = input.nextInt();
					if (Admin.DeleteEntry(id1) == 1)
						System.out.println("Succesfully deleted!");
					else
						System.out.println("Couldn't delete.");
				}
				else
					System.out.println("Need at least one entry to delete.");
		
				break;
			
			// sort directory
			case 4:
				if (Admin.phoneBookDirectory.count >= 2) {
					Admin.Sort(Admin.directory);
					System.out.println("Succesfully sorted!");
				}
				else
					System.out.println("Need at least two entries to sort.");
				break;
			
			// search by phone number
			case 5:
				if (Admin.phoneBookDirectory.count > 0) {
					System.out.print("Enter Phone Number: "); String num1 = input.next();
					if (Admin.LinearSearchByPhoneNumber(num1) == 1)
						System.out.println("Successfully found!");
					else
						System.out.println("Couldn't find.");
				}
				else
					System.out.println("Need at least one entry to search.");
				break;
				
			// search by id
			case 6:
				if (Admin.phoneBookDirectory.count > 0) {
					System.out.print("Enter ID: "); int id2 = input.nextInt();
						
					if (id2 == Admin.SearchByIdBinarySearch(id2).getID())
						System.out.println("Succesfully found! " + Admin.SearchByIdBinarySearch(id2).getFirstName() + " " + Admin.SearchByIdBinarySearch(id2).getLastName());
					else
						System.out.println("Couldn't find.");
						
				}
				else
					System.out.println("Need at least one entry to sort.");
				break;
			
			// print all entries in the admin directory
			case 7:
				if (Admin.phoneBookDirectory.count > 0)
					Admin.printAllEntries();
				else
					System.out.println("Need at least one entry to print.");
				break; 
				
			// print admin info with overrided PrintUserInfo method
			case 8:
				Admin.PrintUserInfo();
				break;
			
			// change Admin username
			case 9:
				System.out.print("Enter new username: "); String user = input.next();
				Admin.changeUsername(user);
				break;
			
			// change Admin password
			case 10:
				System.out.print("Enter new password: "); String pass = input.next();
				Admin.changePassword(pass);
				break;
			} 
			
			} while (choice != 0);
			System.out.println("Goodbye!");
			
		}
		
		else if (username.equals(Normal.username) && password.equals(Normal.password)) {
			System.out.println("Welcome Normal User! Enter the number of what you would like to do!");
			
			
			
			do {
			System.out.println("1. Add Entry \n2. Edit Entry \n3. Sort Directory \n4. Search by Phone Number \n5. Print User Info \n6. Print all Entries in the Directory \n7. Quit");
			choice = input.nextInt();
			
			switch (choice) {
			
			case 1: 
				System.out.print("Enter ID: "); int id = input.nextInt();
				System.out.print("Enter First Name: "); String fn = input.next();
				System.out.print("Enter Last Name: "); String ln = input.next();
				System.out.print("Enter Email Address: "); String email = input.next();
				System.out.print("Enter Zip Code: "); String zip = input.next();
				System.out.print("Enter Phone Number: "); String num = input.next();
				PhoneBookEntry entry = new PhoneBookEntry(id, fn, ln, email, zip, num);
				
				if (Normal.addEntry(entry) == 1) {
					System.out.println("Succesfully added!");
				}
				else
					System.out.println("Directory is full! Couldn't add.");
				break;
				
			case 2:
				if (Normal.phoneBookDirectory.count > 0) {
					System.out.print("Enter First Name: "); String fn1 = input.next();
					System.out.print("Enter Last Name: "); String ln2 = input.next();
					if (Normal.Edit(fn1, ln2) == 1)
						System.out.println("Succesfully editted!");
					else
						System.out.println("Couldn't edit.");
				}
				
				else
					System.out.println("Need at least one entry to edit.");
				break;
				
			case 3:
				if (Normal.phoneBookDirectory.count >= 2) {
					Normal.Sort(Normal.directory);
					System.out.println("Succesfully sorted!");
				}
				else
					System.out.println("Need at least two entries to sort.");
				break;
			case 4:
				if (Normal.phoneBookDirectory.count > 0) {
					System.out.print("Enter Phone Number: "); String num1 = input.next();
					if (Normal.LinearSearchByPhoneNumber(num1) == 1)
						System.out.println("Successfully found!");
					else
						System.out.println("Couldn't find.");
				}
				else
					System.out.println("Need at least one entry to search.");
				break;
			
			case 5:
				Normal.PrintUserInfo();
				break;
			
			case 6:
				if (Normal.phoneBookDirectory.count > 0)
					Normal.printAllEntries();
				else
					System.out.println("Need at least one entry to print.");
				break;
			}
			
			} while (choice != 7);
			System.out.println("Goodbye!");
			
		}
		else 
			System.out.println("Username and Password combination not found!");
	
	}
}
