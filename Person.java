package address;
import java.io.*;
public class Person implements Serializable{
	static final long serialVersionUID=23L;
	private String firstName;
	private String lastName;
	private String phone;
	private Address address1;
	
	Person(String firstName,String lastName,String city,String state,String zip,String phone)
	{
		address1=new Address(city,state,zip);
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void updatePhone(String phone)
	{	
		this.phone=phone;
	}
	
	public void updateCity(String city)
	{	
		address1.updateCity(city);
	}
	public void updateState(String state)
	{	
		address1.updateState(state);
		
	}
	public void updateZip(String zip)
	{	
		address1.updateZip(zip);
		
	}
	
	
	
	public String getZip() {
		return address1.getZip();
	}
	
	public String toString(){
		return firstName+"\n"+lastName+"\n"+address1.toString()+"\n"+phone;
	}

	
}
