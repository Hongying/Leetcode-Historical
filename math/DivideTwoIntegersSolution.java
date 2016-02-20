public class DivideTwoIntegersSolution {
    
    /* if you can use *, use binary search; otherwise use bit operation
    */
    public int divide(int dividend, int divisor) {
        //any number can be converted: num=a_0*2^0+a_1*2^1+a_2*2^2+...+a_n*2^n
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0){
            return 0;
        }
        //in case of overflow, since abs(Integer.MIN_VALUE) > abs(Integer.MAX_VALUE)
        if(divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        int diff = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? 1 : -1;
        // in case of overflow; note the type conversion below! if no conversion, TLE
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int result = 0;
        //b's value never changed in the following code
        while(a >= b){
            int numShift = 0;
            while(a >= (b << numShift) ){
                numShift++;
            }
            result = result + (1 << (numShift - 1));
            a = a - (b << (numShift - 1));
            System.out.println("a = " + a + ", b = "+b);
        }
        return result * diff;
    }
}