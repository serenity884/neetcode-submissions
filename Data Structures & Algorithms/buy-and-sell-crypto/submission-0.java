class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minBuy = Math.min(minBuy, price); // cheapest price seen SO FAR
            maxProfit = Math.max(maxProfit, price - minBuy); // profit if sold today
        }
        return maxProfit;
    }
}
