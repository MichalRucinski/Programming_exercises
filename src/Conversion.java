/*
Create a function taking a positive integer as its parameter and returning a string containing 
the Roman Numeral representation of that integer. Modern Roman numerals are written by expressing 
each digit separately starting with the left most digit and skipping any digit with a value of 
zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is 
written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.
 */
public class Conversion {

	public static String solution(int n) {

		StringBuilder result = new StringBuilder("");
		int[] numbers = { 0, 0, 0, 0, 0, 0, 0 };
		Double[] numbersDouble = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

		numbers[0] = (int) n / 1000;
		n = n - numbers[0] * 1000;
		numbers[1] = (int) n / 500;
		n = n - numbers[1] * 500;
		numbers[2] = (int) n / 100;
		n = n - numbers[2] * 100;
		numbers[3] = (int) n / 50;
		n = n - numbers[3] * 50;
		numbers[4] = (int) n / 10;
		n = n - numbers[4] * 10;
		numbers[5] = (int) n / 5;
		n = n - numbers[5] * 5;
		numbers[6] = n;

		for (int i = 0; i < 7; i++) {
			numbersDouble[i] = (double) numbers[i];
			if (numbersDouble[i] == 4.0 && numbersDouble[i - 1] == 1) {
				numbersDouble[i] = 0.0;
				numbersDouble[i - 1] = 0.0;
				numbersDouble[i - 2] = numbersDouble[i - 2] + 0.9;
			}
			if (numbersDouble[i] == 4.0 && numbersDouble[i - 1] == 0) {
				numbersDouble[i] = 0.0;
				numbersDouble[i - 1] = 0.9;
			}

		}
		String[] symbols = new String[] { "M", "D", "C", "L", "X", "V", "I" };

		for (int i = 0; i < 7; i++) {
			for (int amountOfSameSymbols = 0; amountOfSameSymbols < numbersDouble[i]
					.intValue(); amountOfSameSymbols++) {
				result = result.append(symbols[i]);
			}
			if (numbersDouble[i] != numbersDouble[i].intValue() && i % 2 == 0) {
				result.append(symbols[i + 2]);
				result.append(symbols[i]);
			}
			if (numbersDouble[i] != numbersDouble[i].intValue() && i % 2 != 0) {
				result.append(symbols[i + 1]);
				result.append(symbols[i]);
			}
		}
		System.out.println(result.toString());
		return result.toString();
	}

	public static void main(String[] args) {
		// enter an number in brackets below
		solution(1267);

	}

}
