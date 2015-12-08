
import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeInorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        //non-recursive 1
        List<Integer> result = new LinkedList<Integer>();
        if(root == null){ 
            return result;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(true){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            
            //or omit the if in the following and change the while loop condition to p!=null || !stack.empty()
            if(stack.isEmpty()){
               break; 
            }
            p = stack.pop();
            result.add(p.val);
            p = p.right;
        }
        return result;
        
        /*
        //non-recursive 2
        //don't loop through the most left node all at once;
        //do it once for each iteration
        //if an element is poped/visited, that means its left subtree is visited; directly visit its subtree
        List<Integer> result = new LinkedList<Integer>();
        if(root == null){ return result;}
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.empty() || p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }else{
              p = stack.pop();
              result.add(p.val);
              p = p.right;
            }
        }
        return result;
        */
        
        /*
        //recursive
        List<Integer> result = new LinkedList<Integer>();
             
        helper(root,result);
        return result;
        */
    }    
    
    /* 
    //recursive
    public void helper(TreeNode p, List<Integer> list){ 
        if(p!=null){
        if(p.left!=null) helper(p.left,list);
        list.add(p.val);
        if(p.right!=null) helper(p.right,list);
        }
     }
    */
}