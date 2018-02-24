/*
#Sorting on planet Twisted-3-7
There is a planet... in a galaxy far far away. It is exactly like our planet, but it has one difference:
#The values of the digits 3 and 7 are twisted. Our 3 means 7 on the planet Twisted-3-7. And 7 means 3.
Your task is to create a method, that can sort an array the way it would be sorted on Twisted-3-7.
7 Examples from a friend from Twisted-3-7:

[1,2,3,4,5,6,7,8,9] -> [1,2,7,4,5,6,3,8,9]
[12,13,14] -> [12,14,13]
[9,2,4,7,3] -> [2,7,4,3,9]

There is no need for a precheck. The array will always be not null and will always contain at least one number.
You should not modify the input array!
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Kata {
	
  public static Integer[] sortTwisted37(Integer[] array) {
	  
	  ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
	  
	  Collections.sort(list, new Comparator<Integer>() {

		public int compare(Integer int1, Integer int2) {
			String stringInt1 = int1.toString();
			String stringInt2 = int2.toString();
			stringInt1 = stringInt1.replace('3', 'x');
			stringInt1 = stringInt1.replace('7', '3');
			stringInt1 = stringInt1.replace('x', '7');
			stringInt2 = stringInt2.replace('3', 'x');
			stringInt2 = stringInt2.replace('7', '3');
			stringInt2 = stringInt2.replace('x', '7');
			int1 = Integer.parseInt(stringInt1);
			int2 = Integer.parseInt(stringInt2);
			
			return (int1>int2)? 1 : (int1<int2)? -1 : 0;
		}
		  
	  });
	  
	  Integer[] output = new Integer[list.size()];
	  list.toArray(output);
	  for(Integer a: output)
		  System.out.println(a);
	  
	  
    return output;
  }
  
  
  
  
	public static void main(String[] args) {
		// entry array below
		Kata.sortTwisted37(new Integer[] {1,2,3,4,5,6,7,8,9});

	}

}
