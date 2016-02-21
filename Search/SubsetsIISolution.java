public class SubsetsIISolution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sets = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return sets;
        }
        Arrays.sort(nums);
        sets.add(new LinkedList<Integer>());
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            int n = sets.size();
            if (i == 0 || nums[i] != nums[i-1]){
                k = sets.size();
            }
            for(int j = n - k; j < n; j++){
                List<Integer> x = new LinkedList<Integer>();
                x.addAll(sets.get(j));
                x.add(nums[i]);
                sets.add(x);
            }
        }
        return sets;
    }
}
/* //version 2
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(num == null || num.length ==0) {
            return result;
        }
        Arrays.sort(num);
        subsetsHelper(result, list, num, 0);

        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < num.length; i++) {
            if ( i != pos && num[i] == num[i - 1]) {
                continue;
            }    
            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
*/