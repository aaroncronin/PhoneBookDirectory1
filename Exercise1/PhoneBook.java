import java.util.Scanner;
public class PhoneBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner input = new Scanner(System.in);
		
		// first object
		System.out.println("FIRST ENTRY:");
		System.out.print("ID: ");
		int id = input.nextInt();
		System.out.print("First Name: ");
		String fn = input.next();
		System.out.print("Last Name: ");
		String ln = input.next();
		System.out.print("Email: ");
		String eml = input.next();
		System.out.print("Zip Code: ");
		String zip = input.next();
		System.out.print("Phone Number: ");
		String num = input.next();
		
		PhoneBookEntry FirstObject = new PhoneBookEntry(id, fn, ln, eml, zip, num);
		
		
		// second object
		System.out.println("\nSECOND ENTRY:");
		System.out.print("First Name: ");
		String fn2 = input.next();
		System.out.print("Phone Number: ");
		String num2 = input.next();
	
		PhoneBookEntry SecondObject = new PhoneBookEntry(fn2, num2);
		
		
		// third object
		System.out.println("\nTHIRD ENTRY:");
		System.out.print("First Name: ");
		String fn3 = input.next();
		
		PhoneBookEntry ThirdObject = new PhoneBookEntry(fn3);
		
		// call the setPhoneNumber method on the FirstObject
		FirstObject.setPhoneNumber("202555555");
		
		// call the printBookEntry method on the FirstObject in order to print the attributes of the object
		FirstObject.printBookEntry();
		
		// call the setZipCode method on the SecondObject and set the zip code equal to the zip code of the
		// FirstObject by using the getZipCode method
		SecondObject.setZipCode(FirstObject.getZipCode());
		
		
		
		
	}

}
