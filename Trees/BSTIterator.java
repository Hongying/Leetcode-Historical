//tested in Eclipse; leetcode shows weird error

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode curr;

    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        curr = root;
    }

    // @return: True if there has next node, or false
    public boolean hasNext() {
        return (curr != null || !stack.isEmpty());
    }

    // @return: return next node
    public TreeNode next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        TreeNode x = curr;
        curr = curr.right;
        return x;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n2.right = n3;
        n3.right = n4;
        TreeNode root = n2;

        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next().val);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
