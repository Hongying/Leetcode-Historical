
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
    //version 1: non-recursive
        /*  
        * in-place convert a BST to doubly linked list; consider inorder traversal because
        * of the order; for the list, pre pointer is easy because we don't revisit the previous node 
        * again, we need to record the previous node; and the head; at last connect head and tail
        * p points to the current node; q points to the previous node; when the loop ends, p is null
        * and q is previous node visited, i.e., the tail
        */
    public TreeNode inorderTraversal(TreeNode root) {
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
    //version 2 recursive, from http://cslibrary.stanford.edu/109/TreeListRecursion.html   
    //very neat solution; note here small pointer is the left pointer, and large is the right pointer
    /*
    Trust that the recursive calls return correct output when fed correct input -- make the leap of faith. 
    Look at the partial results that the recursive calls give you, and construct the full result from them. 
    If you try to step into the recursive calls to think how they are working, you'll go crazy.
    */
    public static void join(Node a, Node b) {
        a.large = b;
        b.small = a;
    }

    
    /*
     helper function -- given two circular doubly linked
     lists, append them and return the new list.
    */
    public static Node append(Node a, Node b) {
        // if either is null, return the other
        if (a==null) return(b);
        if (b==null) return(a);
        
        // find the last node in each using the .previous pointer
        Node aLast = a.small;
        Node bLast = b.small;
        
        // join the two together to make it connected and circular
        join(aLast, b);
        join(bLast, a);
        
        return(a);
    }

    
    /*
     --Recursion--
     Given an ordered binary tree, recursively change it into
     a circular doubly linked list which is returned.
    */
     /*return the linked list head with the linked list 
     which contains all the node from the tree rooted at "root"
     */
    public static Node treeToList(Node root) {
        // base case: empty tree -> empty list
        if (root==null) return(null);
        
        // Recursively do the subtrees (leap of faith!)
        Node aList = treeToList(root.small);
        Node bList = treeToList(root.large);
        
        // Make the single root node into a list length-1
        // in preparation for the appending
        root.small = root;
        root.large = root;
        
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        aList = append(aList, root);
        aList = append(aList, bList);
        
        return(aList);
    } 
}