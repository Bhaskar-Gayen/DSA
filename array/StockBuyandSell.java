package array;

/**
 * LeetCode: 121. Best Time to Buy and Sell Stock Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */

public class StockBuyandSell {

	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i])
				min = prices[i];
			if (prices[i] - min > maxprofit)
				maxprofit = prices[i] - min;
		}
		return maxprofit;
	}

}
