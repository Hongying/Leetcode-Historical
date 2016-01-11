public class PowerOfTwoSolution {
    public boolean isPowerOfTwo(int n) {
        //note: consider these two cases; need to consider Integer.MIN_VALUE because n-1 is used later, overflow if not considered
        if(n == 0 || n == Integer.MIN_VALUE){
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}