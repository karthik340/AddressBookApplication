package address;
import java.io.*;
import java.util.*;
public class AddressBook implements Serializable{
	private String title="untitled";
	static final long serialVersionUID=23L;
	private ArrayList<Person> personList ;
	
	AddressBook()
	{
		personList= new ArrayList<>();
	}
	
	public int getNumberOfPersons() {
		return personList.size();
	}
	
	public String toString()
	{
		return title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public void addPerson(String firstName,String lastName,String city,String state,String zip,String phone) {
		Person person = new Person(firstName,lastName,city,state,zip,phone);
		personList.add(person);
	}

	public String getFullNameOfPerson(int index) {
		String a = personList.get(index).getFirstName();
		String b = personList.get(index).getLastName();
		return a + b;
	}

	public void getOthePersonInformation(int index) {
		Person person = personList.get(index);
		System.out.println(person);
	}

	public void updatePhone(int index,String phone)
	{	
		personList.get(index).updatePhone(phone);
	}
	
	public void updateCity(int index,String city)
	{	
		personList.get(index).updateCity(city);
	}
	
	public void updateState(int index,String state)
	{	
		personList.get(index).updateState(state);
	}
	
	public void updateZip(int index,String zip)
	{	
		personList.get(index).updateZip(zip);
	}
	public void removePerson(int index) {
		personList.remove(index);
	}

	public void sortByName() {
		Collections.sort(personList, new CompareByName());
	}

	public void sortByZip() {
		Collections.sort(personList, new CompareByZip());
	}

	public void printAll() {
		System.out.println("hi");
		int index=0;
		for (int i=0;i<personList.size();i++) {
			System.out.println(index+". "+personList.get(i).getFirstName() + personList.get(i).getLastName());
		    index++;
		}
	}
	
	
		
		
	}
	


