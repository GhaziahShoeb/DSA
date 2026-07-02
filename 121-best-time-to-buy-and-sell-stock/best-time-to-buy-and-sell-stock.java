class Solution {
    public int maxProfit(int[] prices) {

        // Stores the lowest stock price seen so far.
        // We initialize it to the largest possible integer so that
        // the first price in the array will always become the new minimum.
        int minPrice = Integer.MAX_VALUE;

        // Stores the maximum profit found so far.
        // Initially, no transaction has been made, so profit is 0.
        int maxProfit = 0;

        // Traverse through each stock price one by one.
        for (int price : prices) {

            // If the current price is lower than the minimum price seen so far,
            // update minPrice because this would be a better day to buy.
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate the profit if we sell the stock today
            // after buying it at the lowest price seen so far.
            int profit = price - minPrice;

            // If today's profit is greater than the maximum profit
            // we've seen before, update maxProfit.
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        // Return the maximum profit possible.
        // If no profit is possible, maxProfit will remain 0.
        return maxProfit;
    }
}