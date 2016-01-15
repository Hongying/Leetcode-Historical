public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] result = new int[amount+1];
        result[0] = 0;
        for(int i = 1; i < amount + 1; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && result[i - coins[j]] != Integer.MAX_VALUE){
                    min = Math.min(min, result[i - coins[j]] + 1);
                }
            }
            result[i] = min;
        }
        return result[amount] == Integer.MAX_VALUE ? -1 : result[amount];
    }
}
