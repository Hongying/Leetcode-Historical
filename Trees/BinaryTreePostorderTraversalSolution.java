/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //import Stack and ArrayList
public class BinaryTreePostorderTraversalSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //m1: non-recursive, using 1 stack
        List<Integer> list = new LinkedList<Integer>();
        if(root == null){
            return list;
        }
        //p is the current node, q is its previous node
        TreeNode p = null, q = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            p = stack.peek();
            boolean childVisited = false;
            if(q != null && (p.left == q || p.right == q)){
                childVisited = true;
            }
            if(childVisited == true || p.left == null && p.right == null){
                list.add(p.val);
                stack.pop();
                q = p;
            }else{
                if(p.right != null){
                    stack.push(p.right);
                }
                if(p.left != null){
                    stack.push(p.left);
                }
            }
        }
        return list;

        //m2: non-recursive
        List<Integer> postorder = new ArrayList<Integer>();
        if(root == null){
            return postorder;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode p = root;
        stack1.push(root);
        while(!stack1.empty()){
            //push to stack 2 every time pop from stack 1
            p = stack1.pop();
            stack2.push(p);
            if(p.left != null){
                stack1.push(p.left);
            }
            if(p.right != null){
                stack1.push(p.right);
            }
        }
        while(!stack2.empty()){
            postorder.add(stack2.pop().val);
        }
        return postorder;
    }
}