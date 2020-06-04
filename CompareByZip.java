package address;
import java.util.*;
public class CompareByZip implements Comparator<Person> {
	public int compare(Person person1,Person person2){
		int compareByZip = person1.getZip().compareTo(person2.getZip()); 
		if(compareByZip!=0)
			return compareByZip;
		else{
			return new CompareByName().compare(person1, person2);
		}
			
	}
	

	
}
