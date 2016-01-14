public class JumpGameIISolution {
    public int jump(int[] nums) {
        /* //version 1: DP not optimal
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break; //no need to check between current j and i
                }
            }
        }
        */
        
        //version 2: Greedy; suppose you can always reach the last index
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = 0;
        int furthest = 0;
        //every time jump from (anywhere between start and end) to (start+1,furthest), where next jump begins. 
        int jumps = 0;
        //note the condition here: not (end < nums.length), because when end = nums.length, no need to go into the loop because the last element is reachable
        while(end < nums.length - 1){
            jumps++;
            for(int i = start; i <= end; i++){
                if(i + nums[i] > furthest){
                    furthest = i + nums[i];
                }
            }
            start = end + 1;
            end = furthest;
        }
        return jumps; 
    }
}