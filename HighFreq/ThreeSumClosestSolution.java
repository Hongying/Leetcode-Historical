public class ThreeSumClosestSolution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n - 2; i++){
            int j = i + 1;
            int k = n - 1; 
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
                if(sum > target){
                    k--;
                }else if(sum < target){
                    j++;
                }else{
                    return target;
                }
            }
        }
        return result;
    }
}