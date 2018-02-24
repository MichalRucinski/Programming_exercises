/*  Price Draw
 
To participate in a prize draw each one gives his/her firstname. Each letter of a firstname has 
a value which is its rank in the English alphabet. A and a have rank 1, B and b rank 2 and so on.
The length of the firstname is added to the sum of these ranks hence a number n. An array of 
random weights is linked to the firstnames and each n is multiplied by its corresponding weight 
to get what they call a winning number.
Example: names: COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH weights: [1, 4, 4, 5, 2, 1]
PAUL -> n = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54 The weight associated with 
PAUL is 2 so Paul's winning number is 54 * 2 = 108.
Now one can sort the firstnames in decreasing order of the winning numbers. When two people have 
the same winning number sort them alphabetically by their firstnames.
#Task:
parameters: st a string of firstnames, we an array of weights, n a rank
return: the firstname of the participant whose rank is n (ranks are numbered from 1)
#Example: names: COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH weights: [1, 4, 4, 5, 2, 1] n: 4

The function should return: PauL
#Note: If st is empty return "No participants".
If n is greater than the number of participants then return "Not enough participants".
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Rank {
    
    public static String nthRank(String st, Integer[] we, int n) {
        
      if(st.length() == 0)
        return "No participants";
      
      String[] array = st.split(",");
      if(n>array.length)
        return "Not enough participants";
      List<Participant> list = new ArrayList<Participant>();
      
      for(int i=0; i<array.length; i++) {
        int nameValue = array[i].length();
        for(int ii=0; ii<array[i].length(); ii++) {
        char letter = array[i].toLowerCase().charAt(ii);
        nameValue = nameValue + (letter - 'a' +1);
        }
        Participant participant = new Participant(array[i], we[i], nameValue*we[i]);
        list.add(participant);
      }
        Collections.sort(list, new Comparator<Participant>(){
        public int compare(Participant p1, Participant p2) {
          if(p1.getWinningNumber()>p2.getWinningNumber())
            return -1;
          else if(p1.getWinningNumber()<p2.getWinningNumber())
            return 1;
          else if(p1.getWinningNumber()==p2.getWinningNumber()) 
            return p1.getName().compareToIgnoreCase(p2.getName());
          
          return 0;
        }
        });
      return list.get(n-1).getName();
    }
}
  class Participant{
      
      private String name;
      private Integer weight;
      private int winningNumber;
    
    public Participant(String name, Integer weight, int winningNumber) {
      this.name = name;
      this.weight = weight;
      this.winningNumber = winningNumber;
    }
    public String getName() {
    return name;
    }
    public int getWinningNumber() {
      return winningNumber;
    }     
}