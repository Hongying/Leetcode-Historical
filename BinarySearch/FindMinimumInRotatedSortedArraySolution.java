public class FindMinimumInRotatedSortedArraySolution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] <= nums[high]){
                high = mid;
            }else{
                low = mid;
            }
        }
        if(nums[low] <= nums[high]){
            return nums[low];
        }
        return nums[high];
    }
}