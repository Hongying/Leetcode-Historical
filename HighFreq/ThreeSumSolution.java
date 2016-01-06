public class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        //fix 1 number, find the other two numbers after this number
        for(int i = 0; i < nums.length; i++){
            //remove duplicates for the first element
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[j] + nums[k] + nums[i];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    //remove duplicates
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(k > j && nums[k] == nums[k+1]){
                        k--;
                    }
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}