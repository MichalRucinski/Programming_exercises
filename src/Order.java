/*
Your task is to sort a given string. Each word in the String will contain a single number. This 
number is the position the word should have in the result. Note: Numbers can be from 1 to 9. 
So 1 will be the first word (not 0). If the input String is empty, return an empty String. 
The words in the input String will only contain valid consecutive numbers.
For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"
 */

import java.util.ArrayList;

public class Order {
	
	public static String order(String string) {
		
		int i = 0;
		int counter = 0;
		String result = "";
		ArrayList<String> list = new ArrayList<String>(0);
		String[] stringArray = string.split(" ");
		
		if (stringArray.length == 1 && stringArray[0].equals(""))
			return result;
		for (i = 0; i < stringArray.length;) {
			String s = Integer.toString(i + 1);
			for (int ii = 0; ii < stringArray.length; ii++) {
				if (stringArray[ii].contains(s)) {
					list.add(stringArray[ii]);
					stringArray[ii] = "null";
				}
			}
			if (i == (stringArray.length - 1) && (list.size() != stringArray.length)) {
				i = 0;
			} else {
				i++;
				counter++;
			}
			if (counter > stringArray.length * stringArray.length)
				break;
		}
		for (int j = 0; j < list.size(); j++) {

			result = result + list.get(j);
			if (j != list.size() - 1)
				result = result + " ";
		}

		return result;
	}
}
