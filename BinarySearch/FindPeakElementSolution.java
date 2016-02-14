public class  FindPeakElementSolution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0; 
        int high = nums.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            if(nums[mid + 1] > nums[mid]){
                low = mid;
            }else{
                high = mid;
            }
        }
        return nums[high] >= nums[low] ? high : low;
    }
}