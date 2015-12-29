public class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        //version 2: backtrack; primary
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        helper2(result, new ArrayList<Integer>(), nums);
        return result;

        /*
        //version 1: add elt. one by one to every possible positions, e.g. for [1], add 2 -> [2 1], [1 2]
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return result;
        }
        result.add(new ArrayList<Integer>());
        helper1(result, nums, 0);
        return result;
        */
    }
    /*
    //version 1: keep adding each elt. (ith elt.) in nums into result
    public void helper1(List<List<Integer>> result, int[] nums, int index){
        if(index == nums.length){
            return;
        }
        //add i+1 th elt.
        helper1(result, nums, index + 1);
        int elt = nums[index];
        int m = result.size();
        for(int j = 0; j < m; j++){
            //NOTE: since every time the first elt. is removed, always get and remove the first elt.!!!
            //Do this m times to completely get ride of elt. in the result list from last helper1 call 
            
            List<Integer> x = result.get(0);
            int n = x.size();
            //insert elt into every possible position
            for(int i = 0; i <= n; i++){
                List<Integer> temp = new ArrayList<Integer>(x);
                temp.add(i,elt);
                result.add(temp);
            }
            result.remove(0);
        }
    }
    */
    
    /* version 2: a helper method, 
    keep growing list, when it has all the items in nums, add it to the result;
    */
    
    public void helper2(List<List<Integer>> result, List<Integer> list, int[] nums){
      if(list.size() == nums.length){
          List<Integer> listC = new ArrayList<Integer>(list);
          result.add(listC);
          return;
      }  
      for(int x : nums){
          //if list already contains x, ignore it
          if(list.contains(x)){
             continue; 
          }
          list.add(x);
          helper2(result, list, nums);
          list.remove(list.size() - 1);
      }
    }
    
}