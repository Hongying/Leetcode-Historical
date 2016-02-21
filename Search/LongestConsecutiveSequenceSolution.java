public class LongestConsecutiveSequenceSolution{
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int result = 0;
        /*note if using iterator to iterate through the set, difficult; since it's not safe to remove elt. from a set while using iterator
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
        */
        for(int i = 0; i < nums.length; i++){
            int low = nums[i] - 1;
            int high = nums[i] + 1;
            while(set.contains(low)){
                set.remove(low);
                low--;
            }
            while(set.contains(high)){
                set.remove(high);
                high++;
            }
            //the sequence is from (low + 1) to (high - 1)
            result = Math.max(result, high - low - 1);
        }
        return result;
    }
}