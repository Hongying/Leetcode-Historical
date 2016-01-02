public class MajorityElementIISolution {
    public List<Integer> majorityElement(int[] nums) {
        
        long c1 = Integer.MAX_VALUE + 1;
        long c2 = Integer.MAX_VALUE + 1;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == c1){
                count1++;
            }else if(nums[i] == c2){
                count2++;
            }else if(count1 == 0){
                c1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                c2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i : nums){
            if(c1 == i){
                count1++;
            }
            if(c2 == i){
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(count1 > nums.length / 3){
            result.add((int)c1);
        }
        if(count2 > nums.length / 3 && c1 != c2){
            result.add((int)c2);
        }
        return result;
    }
}