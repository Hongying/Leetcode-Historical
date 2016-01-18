public class CombinationSumIISolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), 0, result);
        return result;
    }
    public void helper(int[] nums, int target, ArrayList<Integer> list, int pos, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        int prev = -1;
        for(int i = pos; i < nums.length; i++){
            if(nums[i] > target){
                break;
            }
            //this is actually the same as in Combination Sum to avoid duplicates
            //note i starts from pos; helper's parameters
            if(prev != nums[i]){
                list.add(nums[i]);
                helper(nums, target - nums[i], list, i + 1, result);
                list.remove(list.size() - 1);
                prev = nums[i];
            }
        }
    }
}