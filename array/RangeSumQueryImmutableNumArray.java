public class RangeSumQueryImmutableNumArray {
    //version 1
    //int[][] f;
    
    //version 2
    int[] sum;
    
    public NumArray(int[] nums) {
        /*
        //version 1: time limit exceeded
        if(nums != null && nums.length != 0){
           int n = nums.length;
           f = new int[n][n];
           for(int i = 0; i < nums.length; i++){
               for(int j = i; j < nums.length; j++){
                   if(j == i){
                       f[i][j] = nums[i];
                   }else{
                       f[i][j] = f[i][j-1] + nums[j];
                   }
               }
           }
        }
        */
        //version 2
        if(nums != null){
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for(int i = 1; i < nums.length + 1; i++){
                sum[i] = sum[i - 1] + nums[i - 1];
            }
         }
    }

    public int sumRange(int i, int j) {
        /* //version 1
        if(f != null && i < f.length && j < f.length){
            return f[i][j];
        }
        return -1;
        */
        if(sum == null || i >= sum.length || j >= sum.length){
            return -1;
        }
        return sum[j + 1] - sum[i];
    }
    
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);