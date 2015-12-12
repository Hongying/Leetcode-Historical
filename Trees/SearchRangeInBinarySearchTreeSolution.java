/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SearchRangeInBinarySearchTree Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root,k1,k2,result);
        return result;
    }
    public void helper (TreeNode root, int k1, int k2, List<Integer> result){
        if(root == null){
            return;
        }
        
        if(root.val > k2){
            helper(root.left,k1,k2,result);
        }
        if(root.val >= k1 && root.val <= k2){
        	//note the order of the following 
            helper(root.left,k1,k2,result);
            result.add(root.val);
            helper(root.right,k1,k2,result);
        }
        if(root.val < k1){
            helper(root.right,k1,k2,result);
        }
    }
}
