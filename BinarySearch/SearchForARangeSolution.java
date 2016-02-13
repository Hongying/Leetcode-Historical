public class  SearchForARangeSolution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int firstPos = -1; 
        int lastPos = -1;
        int low = 0; 
        int high = nums.length - 1;
        //find the first position of target
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < target){
                low = mid;
            }else{
                high = mid;
            }
        }
        if(nums[low] == target){
            firstPos = low;
        }else if(nums[high] == target){
            firstPos = high;
        }
        //find the last position of target
        low = 0;
        high = nums.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target){
                low = mid;
            }else{
                high = mid;
            }
        }
        if(nums[high] == target){
            lastPos = high;
        }else if(nums[low] == target){
            lastPos = low;
        }
        return new int[]{firstPos, lastPos};
    }
}