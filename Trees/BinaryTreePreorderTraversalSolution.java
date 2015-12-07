/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreorderTraversalSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //non-recursive
        
        List<Integer> preorder = new ArrayList<Integer>();
        if(root == null){
            return preorder;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        stack.push(p);
        while(!stack.isEmpty()){
            p = stack.pop();
            preorder.add(p.val);
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                stack.push(p.left);
            }
        }
        return preorder;
        
        
        //recursive 1
        /*
        List<Integer> preorder = new ArrayList<Integer>();
        preorderHelper(root, preorder);
        return preorder;
        */
        
        //recursive 2
        /*
        List<Integer> preorder = new ArrayList<Integer>();
        if(root == null){
            return preorder;
        }
        preorder.add(root.val);
        List<Integer> preorderLeft = preorderTraversal(root.left);
        List<Integer> preorderRight = preorderTraversal(root.right);
        preorder.addAll(preorderLeft);
        preorder.addAll(preorderRight);
        return preorder;
        */
    }
    
    //recursive 1
    /*
    public void preorderHelper(TreeNode root, List<Integer> preorder){
        if(root == null){
            return;
        }
        preorder.add(root.val);
        preorderHelper(root.left, preorder);
        preorderHelper(root.right, preorder);
    }
    */
    
}