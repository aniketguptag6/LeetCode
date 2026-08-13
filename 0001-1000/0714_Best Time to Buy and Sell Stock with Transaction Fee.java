class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;                 // Max profit when not holding stock
        int hold = -prices[0];        // Max profit when holding stock

        for (int i = 1; i < prices.length; i++) {
            int prevCash = cash;

            // Sell today or do nothing
            cash = Math.max(cash, hold + prices[i] - fee);

            // Buy today or keep holding
            hold = Math.max(hold, prevCash - prices[i]);
        }

        return cash;
    }
}
