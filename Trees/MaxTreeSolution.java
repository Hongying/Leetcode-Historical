/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，BAT国内班
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

/*
Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
*/

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */
 //solution 1
public class MaxTreeSolution {
  /**
   * @param A
   *            : Given an integer array with no duplicates.
   * @return: The root of max tree.
   */
  public static TreeNode maxTree(int[] A) {
    // write your code here
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode root = null;
    for (int i = 0; i <= A.length; i++) {
        //the right elt.
        TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
            : new TreeNode(A[i]);
        //while the stack is not empty, check the current elt. and the right elt.
        while (!stack.isEmpty()) {
            //if right elt. > current elt., pop the current elt. from the stack
            if (right.val > stack.peek().val) {
                TreeNode nodeNow = stack.pop();
                //if after pop, stack is empty, just put the current node as the left subtree of the right elt.
                if (stack.isEmpty()) {
                    right.left = nodeNow;
                } else {
                //compare the left and the right elt. and decide which one to be the father of the current elt.
                //the smaller one should be the parent
                    TreeNode left = stack.peek();
                    if (left.val > right.val) {
                      right.left = nodeNow;
                    } else {
                      left.right = nodeNow;
                    }
                }
            } else{
                break;
            }
        }
      stack.push(right);
    }
    /*now stack has only the MAX_VALUE node in it. if you consider it as an array elt., all the original
    array elt. should be in its left tree
    */
    return stack.peek().left; 
  }
}