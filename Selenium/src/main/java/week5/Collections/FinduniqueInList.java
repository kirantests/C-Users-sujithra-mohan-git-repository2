package week5.Collections;

import java.util.ArrayList;
import java.util.List;

public class FinduniqueInList {

	public static void main(String[] args) {
		// Class session - Find unique characters in the below string using LIST
		
		String data = "Amazon india had 15Lakh employees";
		List<Character> ls = new ArrayList<>();
		char[] allchar = data.toCharArray();
		
		for(char eachchar:allchar)
		{
		if(!ls.contains(eachchar)) {
			ls.add(eachchar);
			}
		}
        System.out.println(ls);
        
        
	}

}
