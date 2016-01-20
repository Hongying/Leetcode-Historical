public class MoveZeroesSolution {
    public void moveZeroes(int[] nums) {
        int cur = 0; 
        //cur is the current index that points to the first element after non-zero elements so far (for index <= i)
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[cur] = nums[i];
                cur++;
            }
        }
        for(int i = cur; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}