public class  BestTimeToBuyAndSellStockIISolution {
    /* //version 1
        if(prices == null || prices.length == 0){
            return 0;
        }
        int high = prices[0];
        int low =prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < low){
                low = prices[i];
                high = low;
            }else if( prices[i] > high){
                high = prices[i];
                if(high - low > profit){
                    profit = high - low;
                }
            }
        }
        return profit;
        */
        //version 2
        if(prices == null || prices.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE; //profit
        int min = Integer.MAX_VALUE;
        for(int i : prices){
            min = Math.min(min, i);
            max = Math.max(max, i - min);
        }
        return max;
}