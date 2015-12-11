/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorBSTSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode small = p.val > q.val ? q : p;
        TreeNode big = p.val > q.val ? p : q;
        TreeNode t = root;
        while(t != null){
            if(t.val == small.val){
                return small;
            }
            if(t.val == big.val){
                return big;
            }
            if(t.val > small.val && t.val < big.val){
                return t;
            }
            if(t.val < small.val){
                t = t.right; 
                continue;
            }
            if(t.val > big.val){
                t = t.left;
                continue;
            }
        }
        return null;
    }
}