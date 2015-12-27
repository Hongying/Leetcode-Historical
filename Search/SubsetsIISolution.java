public class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sets = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return sets;
        }
        Arrays.sort(nums);
        sets.add(new LinkedList<Integer>());
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            int n = sets.size();
            if (i == 0 || nums[i] != nums[i-1]){
                k = sets.size();
            }
            for(int j = n - k; j < n; j++){
                List<Integer> x = new LinkedList<Integer>();
                x.addAll(sets.get(j));
                x.add(nums[i]);
                sets.add(x);
            }
        }
        return sets;
    }
}