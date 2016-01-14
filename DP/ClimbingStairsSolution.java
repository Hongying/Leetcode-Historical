public class ClimbingStairsSolution {
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i = 2; i < n + 1; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}