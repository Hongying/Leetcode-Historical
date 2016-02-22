//median II from lintcode

public class DataStreamMedianSolution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int n = nums.length;
        int[] median = new int[n];
        // write your code here
        //left should be a max heap, write a comparator or just push a negative number in it 
        //right should be a min heap, i.e. priority queue
        PriorityQueue<Integer> left = new PriorityQueue<Integer>((n+1)/2, new Comparator<Integer>(){
              public int compare(Integer a, Integer b){
                if(a == b){
                    return 0;
                }
                return a < b ? 1 : -1;
                // or return b - a
              }
            });
        PriorityQueue<Integer> right = new PriorityQueue<Integer>((n+1)/2, new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                if(a == b){
                    return 0;
                }
                return a < b ? -1 : 1;
              }
            });
        int mid = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                mid = nums[i];
            }else{
                // |left| is either |right| or |right - 1|
                if(nums[i] <= mid){
                    left.offer(nums[i]);
                    if(left.size() > right.size()){
                        right.offer(mid);
                        mid = left.poll();
                    }
                }else{
                    right.offer(nums[i]);
                    if(right.size() - left.size() > 1){
                        left.offer(mid);
                        mid = right.poll();
                    }
                }
            }
            median[i] = mid;
        }
        return median;
    }
}