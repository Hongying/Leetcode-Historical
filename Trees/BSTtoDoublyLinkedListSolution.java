
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
public class BSTtoDoublyLinkedListSolution {
    public TreeNode inorderTraversal(TreeNode root) {
        //thoughts: http://articles.leetcode.com/convert-binary-search-tree-bst-to/
        /*  
        * in-place convert a BST to doubly linked list; consider inorder traversal because
        * of the order; for the list, pre pointer is easy because we don't revisit the previous node 
        * again, we need to record the previous node; and the head; at last connect head and tail
        * p points to the current node; q points to the previous node; when the loop ends, p is null
        * and q is previous node visited, i.e., the tail
        */
        if(root == null){ 
            return root;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode head = null;
        TreeNode q = null; //the node before p node
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            //added this part to inorder traversal
            if(head == null){
                head = p; 
                q = p;
            }else{
                q.right = p;
                p.left = q;
                q = p;
            }

            p = p.right;
        }
        //added 
        head.left = q;
        q.right = head;
        return head;
        }    
    
}