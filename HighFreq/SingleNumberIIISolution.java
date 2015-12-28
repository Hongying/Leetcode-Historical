public class SingleNumberIIISolution {
    public int[] singleNumber(int[] nums) {
        //note the way to return a new array with values directly
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int diff = 0;
        for(int x : nums){
            diff = diff ^ x;
        }
        int lastBit = diff - (diff & (diff - 1));
        int n1 = 0, n2 = 0;
        for(int x : nums){
            //& has lowest priority, so use () around &
            if((lastBit & x) == 0){
                n1 = n1 ^ x;
            }else{
                n2 = n2 ^ x;
            }
        }
        int[] result = new int[2];
        result[0] = n1;
        result[1] = n2;
        return result;
    }
}