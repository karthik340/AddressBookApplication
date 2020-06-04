package address;

import java.io.*;
import java.util.*;

public class AddressBookApp implements Serializable {
	static final long serialVersionUID = 23L;
	ArrayList<AddressBook> addressBookList;
	AddressBook currentlyOpen;
	
	AddressBookApp() {
		addressBookList = new ArrayList<>();
	}
	
	
	public int displayAddressBooks(){
		if(addressBookList.size()==0){
			System.out.println("No adress Books to show");
			return 0;
		}
			
		for(AddressBook a:addressBookList){
			System.out.println(a);
		}	
		return 1;
	}
	
	public void loadCurrentAddressBook(String name){
		if(name.equals("untitled")){
			currentlyOpen=new AddressBook();
		}
		else{
			for(AddressBook a:addressBookList){
				if(a.getTitle().equals(name)){
					currentlyOpen = a;
					break;
				}
				}
		}
			
	}
	
	public int getSizeOfAddressBooks(){
		return addressBookList.size();
	}
	public void saveAddressBook(AddressBook ad){
		Scanner input = new Scanner(System.in); 
		if(currentlyOpen.getTitle()=="untitled"){
			System.out.println("enter name of address book");
			String name=input.nextLine();
			currentlyOpen.setTitle(name);
		}
		try{	
			FileOutputStream fwrite = new FileOutputStream("addressbooks.ser");
			ObjectOutputStream os = new ObjectOutputStream(fwrite);
			addressBookList.add(ad);
			os.writeObject(ad);
			os.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
	}
	
	public void loadAddressBooks()
		{	try{
				FileInputStream fread = new FileInputStream("addressbooks.ser");
				ObjectInputStream os = new ObjectInputStream(fread); 
				boolean cont=true;
				while(cont){
			
					AddressBook obj = (AddressBook)os.readObject();
					if(obj!=null)
						addressBookList.add(obj);
					else
						cont=false;
					addressBookList.add(obj);
				}
				os.close();
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			
		}

	public void controlPersons(){
		int cont=1;
		int edit;
		AddressBook a = currentlyOpen;
		do {
			System.out.println("Enter 1 for adding person into address book");
			System.out.println("Enter 2 for sort by name address book");
			System.out.println("Enter 3 for sort by zip address book");
			System.out.println("Enter 4 for printing all person in address book");
			System.out.println("Enter 5 removing person from address book");
			System.out.println("Enter 6 to get number of persons in address book");
			System.out.println("Enter 7 to get persons other information");
			System.out.println("Enter 8 to save address book");
			System.out.println("Enter 9 to exit current addressbook");
			System.out.println("Enter 10 to edit address book");
			System.out.println("Enter your choice");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {

			case 1:
				System.out.println("Enter the first name");
				String firstName = input.nextLine();
				System.out.println("Enter the last name");
				String lastName = input.nextLine();
				System.out.println("Enter the city");
				String city = input.nextLine();
				System.out.println("Enter the state");
				String state = input.nextLine();
				System.out.println("Enter the zip");
				String zip = input.nextLine();
				System.out.println("Enter the phone");
				String phone = input.nextLine();
				a.addPerson(firstName,lastName,city,state, zip, phone);
				System.out.println("Persons added successfully");
				break;
			case 2:
				a.sortByName();
				System.out.println("Persons are sorted by name successfully");
				break;
			case 3:
				a.sortByZip();
				System.out.println("Persons are sorted by zip successfully");
				break;
			case 4:
				a.printAll();
				break;
			case 5:
				a.printAll();
				System.out.println("Enter index of person you want to remove");
				int index = input.nextInt();
				a.removePerson(index);
				System.out.println("person removed successfully");
				break;
			case 6:
				System.out.println("Number of persons in address book");
				System.out.println(a.getNumberOfPersons());
				break;
			case 7:
				a.printAll();
				System.out.println("Enter index of person you want to get");
				int index1 = input.nextInt();
				a.getOthePersonInformation(index1);
				break;
			case 8:
				saveAddressBook(a);
				break;
			case 9:
				cont=0;
				System.out.println("Do you want to save address book \n 1.yes \n 2.No");
				int choice2=input.nextInt();
				if(choice2==1)
				{
					saveAddressBook(a);
				}
				break;
				
			case 10:
				a.printAll();
				System.out.println("Enter index of person you want to edit");
				int edit1 = input.nextInt();
				do{	
				System.out.println("Enter 1 to edit city");
				System.out.println("Enter 2 to edit phone");
				System.out.println("Enter 3 to edit zip");
				System.out.println("Enter 4 to edit state");
				System.out.println("Enter 5 to exit");
				edit = input.nextInt();
				input.nextLine();
				switch (edit) {

				case 1:
					System.out.println("Enter the city");
					String city1 = input.nextLine();
					a.updateCity(edit1, city1);
					break;
				case 2:
					System.out.println("Enter the phone");
					String phone1 = input.nextLine();
					a.updatePhone(edit1, phone1);
					break;
				case 3:
					System.out.println("Enter the zip");
					String zip1 = input.nextLine();
					a.updateZip(edit1, zip1);
					break;
				case 4:
					System.out.println("Enter the state");
					String state1 = input.nextLine();
					a.updateState(edit1, state1);
					break;
				case 5:
					edit=5;
					break;
				}
				}while(edit !=  5);
				break;
		} 
		}while (cont == 1);
		}
}
