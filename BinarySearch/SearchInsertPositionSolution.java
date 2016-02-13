public class SearchInsertPositionSolution {
    public int searchInsert(int[] nums, int target) {
        //find the elt. just < target; insert at that index + 1 position
        if(nums == null){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(nums[right] < target){
            return right + 1;
        }if(nums[left] < target){
            return left + 1;
        }
        return left;
    }
}