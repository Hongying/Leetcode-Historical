/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorSolution {
    /**
     * each method call returns
     * (1) p if that subtree contains p
     * (2) q if that subtree contains q
     * (3) null if it contains neither p or q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null){ 
            return root;
        }   
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }
}