/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaximumPathSumSolution {
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int temp = helper(root);
        return result;
    }
    //return the maximum sum from root to a node which is on the path of root to any leaf
    public int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        //find the biggest sum from the root node till any leaf
        //if any of left and right is <0
        int maxOfLR = Math.max(left,right);
        int sum = root.val;
        if(maxOfLR > 0){
            sum = sum + maxOfLR;
        }
        //update result if sum is bigger
        if(sum > result){
            result = sum;
        }
         //check if any path that passes root node is longer
         //left and right both >0
        if(root.val + left + right > result){
            result = root.val + left + right;
        }
        return sum;
    }
}