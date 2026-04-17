class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            }
            maxProfit = Math.max(maxProfit, price - buy);
        }

        return maxProfit;
    }
}