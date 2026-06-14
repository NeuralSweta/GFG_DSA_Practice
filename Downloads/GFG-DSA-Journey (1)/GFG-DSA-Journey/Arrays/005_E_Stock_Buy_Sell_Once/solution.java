// Problem: Buy and Sell a Stock (Single Transaction)
// Difficulty: Easy | Topic: Arrays
// GFG Link: https://www.geeksforgeeks.org/problems/buy-stock-2/1

class Solution {
    public static int maximumProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
