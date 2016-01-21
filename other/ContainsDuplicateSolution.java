public class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        HashSet<Integer> dup = new HashSet<Integer>();
        for(int num : nums){
            if(dup.contains(num)){
                return true;
            }else{
                dup.add(num);
            }
        }
        return false;
    }
}