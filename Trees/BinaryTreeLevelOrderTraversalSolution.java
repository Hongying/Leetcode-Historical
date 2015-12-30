/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversalSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //version 1: BFS
        /*
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelVal = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                levelVal.add(t.val);
                if(t.left != null){
                    queue.offer(t.left);
                }
                if(t.right != null){
                    queue.offer(t.right);
                }
            }
            result.add(levelVal);
        }
        return result;
        */
        //version 2: DFS
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        dfs(result, root, 0);
        return result;
    }
    //version 2
    public void dfs(List<List<Integer>> result, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(result.size() < level + 1){
            result.add(new ArrayList<Integer>());
        }
        //in order traversal; preorder and postorder should be fine too
        dfs(result, root.left, level + 1);
        List<Integer> x = result.get(level);
        x.add(root.val);
        dfs(result, root.right, level + 1);
        
    }
}