// Problem: Stock Buy and Sell (Multiple Transactions)
// Difficulty: Medium | Topic: Arrays
// GFG Link: https://www.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1

class Solution {
    public static long maximumProfit(long[] prices) {
        long profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
