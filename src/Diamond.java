/*
Return a string that displays a diamond shape on the screen using asterisk ("*") characters.
Return null if input is even number or negative (as it is not possible to print diamond 
with even number or negative number).
 */

class Diamond {
	public static String print(int n) {
		boolean isReached = false;
		int count = 1;
		String string = "";
		StringBuffer stringB = new StringBuffer(string);
		int rows = n/2;

		if(n<0 || (n%2==0))
			return null;

		for(int x=1; x<=n; x++) {
			for(int i=1; i<=rows; i++) {
				stringB.append(" ");
			}
			for(int j=1; j<=count; j++) {
				stringB.append("*");
			}
			stringB.append("\n");
			if(count==n)
				isReached=true;
			if(isReached==false) {
				count=count+2;
				rows--;
			}
			else {
				count = count-2;
				rows++;
			}
		}
		string = stringB.toString();
		return string;

	}

	public static void main(String[] args) {

		//enter an odd number in brackets below 
		System.out.println(print(101));
	}


}
