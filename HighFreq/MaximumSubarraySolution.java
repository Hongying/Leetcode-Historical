public class MaximumSubarraySolution {
    public int maxSubArray(int[] nums) {
        /* //version 1: greedy approach
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            sum = sum + i;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
        */
        //version 2: DP
        if(nums == null || nums.length == 0){
            return 0;
        }
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums){
            sum = sum + i;
            max = Math.max(max, sum - minSum);
            //note here: sum, not i; similar to buy and sell stock
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}