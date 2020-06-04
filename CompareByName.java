package address;
import java.util.*;
public class CompareByName implements Comparator<Person> {
	public int compare(Person person1, Person person2){
		int compareByLast = person1.getFirstName().compareTo(person2.getFirstName());
		if(compareByLast!=0)
			return compareByLast;
		else
			return person1.getLastName().compareTo(person2.getLastName()); 
	}

	
}
