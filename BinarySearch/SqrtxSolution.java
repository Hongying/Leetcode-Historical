public class SqrtxSolution {
    //return a value result such that result * result <= x, but (result + 1)^2 > x
    public int mySqrt(int x) {
        if(x < 0){
            return -1;
        }
        int low = 0;
        int high = x; 
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(mid == x / mid){
                return mid;
            }else if(mid < x / mid){
                low = mid;
            }else{
                high = mid;
            }
        }
        if(high * high == x){
            return high;
        }
        return low;
        
    }
}