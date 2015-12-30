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
 
 //lintcode
public class InsertNodeInABinarySearchTreeSolution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        //find node with the biggest number smaller than node.val
        if(root == null){
            root = node;
            return root;
        }
        TreeNode p = root;
        TreeNode x = p;
        while(p != null){
            x = p;
            if(p.val < node.val){
                p = p.right;
            }else{
                p = p.left;
            }
        }
        if(node.val < x.val){
            x.left = node;
        }else{
            x.right = node;
        }
        return root;
    }
    
    //version 2: recursion, from 9chap
     /*public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
    */
}