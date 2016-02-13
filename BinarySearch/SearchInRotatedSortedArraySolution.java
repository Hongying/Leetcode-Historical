public class SearchInRotatedSortedArraySolution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1; 
        }
        int low = 0;
        int high = nums.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[low] < nums[mid]){
                if(target <= nums[mid] && target >= nums[low]){
                    high = mid;
                }else{
                    low = mid;
                }
            }else{
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid;
                }else{
                    high = mid;
                }
            }
        }
        if(nums[low] == target){
            return low;
        }else if(nums[high] == target){
            return high;
        }
        return -1;
    }
}