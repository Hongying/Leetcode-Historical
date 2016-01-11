public class FactorialTrailingZeroesSolution {
    public int trailingZeroes(int n) {
        //depends on number of 5s
        int result = 0;
        /*//below time limit exceeded; also prob. of overflow
        for(int i = 5; i < n; i = i * 5){
            result += n / i;
        }
        */
        while(n > 1){
            result += n / 5;
            n = n / 5;
        }
        return result;
    }
}