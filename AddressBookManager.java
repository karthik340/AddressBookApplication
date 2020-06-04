package address;

import java.util.Scanner;

public class AddressBookManager {

	public static void main(String[] args) {
			int cont=1;
			AddressBookApp addressBookApp = new AddressBookApp();
		do {
			System.out.println("Enter 1 for creating new address book");
			System.out.println("Enter 2 to open existing address books");
			System.out.println("Enter 3 to exit application");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				addressBookApp.loadCurrentAddressBook("untitled");
				addressBookApp.controlPersons();
				break;
			case 2:
				addressBookApp.loadAddressBooks();
				int numOfAddressBooks = addressBookApp.displayAddressBooks();
				if(numOfAddressBooks==0)
					break;
				System.out.println("enter name of address book you want to enter inside");
				String name=input.nextLine();
				addressBookApp.loadCurrentAddressBook(name);
				addressBookApp.controlPersons();
				break;
			case 3:
				cont=0;
				break;
				}
			} while (cont == 1);
		
	}
	
	
	
}
