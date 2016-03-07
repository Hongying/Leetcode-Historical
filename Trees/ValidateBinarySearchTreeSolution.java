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
        return root == null ? true : result.isValid;
    }
    public HelpClass helper(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return new HelpClass(root.val, root.val, true);
        }
        HelpClass left = helper(root.left);
        HelpClass right = helper(root.right);

        if(left != null){
            if(left.isValid == false || left.high >= root.val){
                return new HelpClass(-1,-1,false);
            }
        }
        if(right != null){
            if(right.isValid == false || right.low <= root.val){
                return new HelpClass(-1,-1,false);
            }
        }
        
        //the initilization value is useful when it's a leaf node
        int low = root.val; 
        if(left != null){
            low = left.low;
        }
        int high = root.val;
        if(right != null){
            high = right.high;
        }
        return new HelpClass(high,low,true);
    

        /*
        //version 2: some optimization: no need to calculate high and low if it is already not a BST
        if(root == null){
            return new HelpClass(null,null, true);
        }
        HelpClass left = helper(root.left);
        HelpClass right = helper(root.right);
        boolean isValid = true;
        if(left.isValid == false || right.isValid == false){
            isValid = false;
            return new HelpClass(-1,-1,isValid);
        }
        if(left.high != null && left.high >= root.val){
            isValid = false;
            return new HelpClass(-1,-1,isValid);
        }
        if(right.low != null && right.low <= root.val){
            isValid = false;
            return new HelpClass(-1,-1,isValid);
        }
        //the initilization value is useful when it's a leaf node
        int low = root.val; 
        if(left.low != null){
            low = left.low;
        }
        int high = root.val;
        if(right.high != null && right.high > high){
            high = right.high;
        }
        return new HelpClass(high,low,isValid);
        */
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