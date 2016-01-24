public class ContainsDuplicateIISolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return false;
        }
        //map stores <elt. in the array nums, index of the elt.>
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                //not i is bigger than map.get(nums[i])
                if(i - map.get(nums[i]) <= k){
                    return true;
                }else{
                    //replace the old index value with the new one, since it will be closer to the elt. after the new index
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
}