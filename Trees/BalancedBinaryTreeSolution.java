/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTreeSolution {
    public boolean isBalanced(TreeNode root) {
        int result = helper(root);
        if(result == -1){
            return false;
        }
        return true;
    }
    
    //if the subtree at root p is unbalanced, return -1; if null, return 0; else return the height 
    private int helper(TreeNode p){
        if(p == null){
            return 0;
        }
        int left = helper(p.left);
        int right = helper(p.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }
}