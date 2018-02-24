/*
Write a function, which takes a non-negative integer (seconds) as input and returns the time 
in a human-readable format (HH:MM:SS)

HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)
 */

public class HumanReadableTime {
	
  public static String makeReadable(int seconds) {
     
    return toString(seconds);
  }
	public static void main(String[] args) {
		System.out.println(makeReadable(3730));

	}
	public static String toString(int seconds) {
		
		int hours = (int) seconds/3600;
		int minutes = (int) (seconds%3600)/60;
		seconds = (seconds%3600)%60;
		
		return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
	}

}
