/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumDepthOfBinaryTreeSolution {
    public int minDepth(TreeNode root) {
        //note: tricky, consider the case that 1 child is null, then can't use min to determine the min depth
        //version 3: use a helper method
        //the following if condition avoids dealing with root and null children in the bottom of the tree the same way (which version 1 and version 2 did, so they need to have extra logic to determine the cases)
        if(root == null){
            return 0;
        }
        return helper(root);

        /*
        //version 2: take care of the any child = null cases too, as in version 1
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = minDepth(root.left);
        if(left == 0){
            left = Integer.MAX_VALUE;
        }
        int right = minDepth(root.right);
        if(right == 0){
            right = Integer.MAX_VALUE;
        }
        return Math.min(left,right) + 1;
        */
        
        /* //version 1
        if(root == null){
            return 0;
        }
        int result = 0;
        int temp = minDepth(root.left);
        if(temp != 0){
            result = temp;
        }
        temp = minDepth(root.right);
        if(temp != 0){
            if(result == 0){
                result = temp;
            }else{
                result = temp > result ? result : temp;
            }
        }
        result++;
        return result;
        */
    }
    
    //version 3
    private int helper(TreeNode p){
        if(p == null){
            return Integer.MAX_VALUE;
        }        
        if(p.left == null && p.right == null){
            return 1;
        }
        return Math.min(helper(p.left),helper(p.right)) + 1;
    }
}