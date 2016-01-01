import java.util.HashMap;
public class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i, map.get(i) + 1);
            }
            if(map.get(i) > n / 2){
                return i;
            }
        }
        return -1;
    }
}