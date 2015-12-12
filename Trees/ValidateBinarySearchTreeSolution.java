/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//will update a version with less computation later
public class ValidateBinarySearchTreeSolution {
    public boolean isValidBST(TreeNode root) {
        HelpClass result = helper(root);
        return result.isValid;
    }
    public HelpClass helper(TreeNode root){
        if(root == null){
            //to avoid the case that some elements has value of Integer.MIN_VALUE or Integer.MAX_VALUE
            return new HelpClass(null,null, true);
        }
        HelpClass left = helper(root.left);
        HelpClass right = helper(root.right);
        boolean isValid = true;
        if(left.high != null && left.high >= root.val){
            isValid = false;
        }
        if(right.low != null && right.low <= root.val){
            isValid = false;
        }
        if(left.isValid == false || right.isValid == false){
            isValid = false;
        }
        int low = root.val; 
        if(left.low != null && left.low < low){
            low = left.low;
        }
        if(right.low != null && right.low < low){
            low = right.low;
        }
        int high = root.val;
        if(left.high != null && left.high > high){
            high = left.high;
        }
        if(right.high != null && right.high > high){
            high = right.high;
        }
        return new HelpClass(high,low,isValid);
    }
     class HelpClass{
         Integer high;
         Integer low;
         boolean isValid;
         public HelpClass(Integer high, Integer low, boolean isValid){
             this.high = high;
             this.low = low;
             this.isValid = isValid;
         }
     }
}