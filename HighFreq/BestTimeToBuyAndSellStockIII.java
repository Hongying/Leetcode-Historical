public class BestTimeToBuyAndSellStockIIISolution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        //if we draw a line after elt. at i, the biggest profit on its left
        int[] left = new int[n];
        //biggest profit on its right
        int[] right = new int[n];
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0; i < n; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
            left[i] = profit;
        }
        int max = Integer.MIN_VALUE;
        profit = 0;
        for(int i = n - 1; i >= 0; i--){
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max - prices[i]);
            right[i] = profit;
        }
        //find the line (the line is between i and i + 1)
        profit = 0;
        for(int i = 1; i + 2 < n; i++){
            profit = Math.max(profit, left[i] + right[i + 1]);
        }
        //return the max of 2 transactions and 1 transaction
        return Math.max(profit, left[n-1]);
    }
}