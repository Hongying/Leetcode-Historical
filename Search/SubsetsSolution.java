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
}