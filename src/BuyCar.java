/*
A man has a rather old car being worth $2000. He saw a secondhand car being worth $8000. He wants to keep his old car 
until he can buy the secondhand one. He thinks he can save $1000 each month but the prices of his old car and of the 
new one decrease of 1.5 percent per month. Furthermore the percent of loss increases by a fixed 0.5 percent at the end 
of every two months.
Can you help him? Our man finds it difficult to make all these calculations. How many months will it take him to save 
up enough money to buy the car he wants, and how much money will he have left over?
*/

public class BuyCar {

	public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

		double cash = 0;
		int months = 0;
		double priceNew = startPriceNew;
		double priceOld = startPriceOld;
		int[] result = { 0, 0 };
		while (cash < priceNew - priceOld) {
			// new month starts
			months++;
			priceNew = priceNew - (priceNew * (percentLossByMonth / 100));
			priceOld = priceOld - (priceOld * (percentLossByMonth / 100));
			// at the end of the month
			cash = cash + savingperMonth;
			if (months % 2 != 0)
				percentLossByMonth = percentLossByMonth + 0.5;
		}
		Double leftOver = cash - (priceNew - priceOld);
		result[0] = months;
		result[1] = (int) Math.round(leftOver);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(nbMonths(2000, 8000, 1000, 1.5));

	}

}
