Stock Buy and Sell – Max one Transaction Allowed - https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/buy-stock-2

class Solution {
    public int maximumProfit(int prices[]) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Update the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate potential profit and update maxProfit
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }
}
