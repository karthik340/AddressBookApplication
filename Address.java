package address;

import java.io.Serializable;

public class Address implements Serializable{
	static final long serialVersionUID=23L;
	private String city;
	private String state;
	private String zip;
	
	Address(String city,String state,String zip)
	{
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	
	public void updateCity(String city)	
	{
		this.city=city;	
	}
	public void updateState(String state)	
	{
		this.state=state;
	}
	public void updateZip(String zip)	
	{
		this.zip=zip;
	}
	public String toString(){
		return city+"\n"+state+"\n"+zip;
	}
	
		}
