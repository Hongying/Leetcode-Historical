public class SingleNumberIISolution {
    public int singleNumber(int[] nums) {
        //3 bit masks, 21312, candy
        int ones = 0, twos = 0, threes = 0;
        for(int x : nums){
            twos |= ones & x;
            ones = ones ^ x;
            threes = ones & twos;
            ones = ~threes & ones;
            twos = ~threes & twos;
        }
        return ones;
    }
}