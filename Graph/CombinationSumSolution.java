public class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> comb = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return comb;
        }
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), 0, comb);
        return comb;
    }
    private void helper(int[] candidates, int target, List<Integer> list, int pos, List<List<Integer>> comb){
        if(target == 0){
            comb.add(new ArrayList<Integer>(list));
            return;
        }else if(target < 0){
            return;
        }
        
        int prev = -1;
        for(int i = pos; i < candidates.length; i++){
            //two optimizations
            //if use the next, no need of "if(target < 0)" in the above
            if(candidates[i] > target){
                break;
            }
            //skip duplicate characters
            if(prev != -1 && prev == candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], list, i, comb);
            list.remove(list.size() - 1);
            prev = candidates[i];
        }
    }
}