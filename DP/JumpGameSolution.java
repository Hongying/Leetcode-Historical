public class JumpGameSolution {
    public boolean canJump(int[] nums) {
        /* //version 1: DP
        //for each element, check whether the former elements (those with smaller index) can get to it
        */
        //version 2: Greedy
        if(nums == null || nums.length == 0){
            return false;
        }
        int furthest = 0; //an index indicating the furthest position can be jumped to right now
        for(int i = 0; i < nums.length; i++){
            //note the first condition here
            if(i <= furthest && i + nums[i] > furthest){
                furthest = i + nums[i];
            }
            if(furthest >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}