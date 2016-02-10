public class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return sets;
        }
        //add empty set: []
        List<Integer> x = new LinkedList<Integer>();
        sets.add(x);
        Arrays.sort(nums);
        helper(nums, sets, 0);
        return sets;
    }
    /* @param n: the nth element in nums 
        run helper until the last element in nums
    */
    private void helper(int[] nums, List<List<Integer>> sets, int n){
        if(n == nums.length){
            return;
        }
        int temp = nums[n];
        List<List<Integer>> tempSets = new LinkedList<List<Integer>>();
        for(List<Integer> x : sets){
            List<Integer> y = new LinkedList<Integer>();
            y.addAll(x);
            y.add(temp);
            tempSets.add(y);
        }
        sets.addAll(tempSets);
        helper(nums, sets, n + 1);
    }

    //version 2
    public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        subsetsHelper(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }
    
    private void subsetsHelper(int[] nums, List<Integer> list, int index, List<List<Integer>> result){ 
        /*
        if (index == nums.length) {
            return;
        }
        */
        result.add(new ArrayList<Integer>(list));
        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            subsetsHelper(nums, list, i + 1, result);
            list.remove(list.size() - 1);
        }
    }
}
}