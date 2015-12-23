import java.util.Hashtable;
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraphSolution {
      public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        /*
        //version 1: BFS
        if(node == null){
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        queue.offer(node);
        Hashtable<UndirectedGraphNode, UndirectedGraphNode> table = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
        table.put(node, root);
        while(!queue.isEmpty()){
            UndirectedGraphNode p = queue.poll();
            //since you only add a node to the queue when it's the first time you see it, there's no repeatable elments in the queue; thus deal with one node only once
            for(UndirectedGraphNode x : p.neighbors){
                //only if the table doesn't contains x (encounter x the first time), add it to the table and the queue
                if(!table.containsKey(x)){
                    queue.offer(x);
                    table.put(x, new UndirectedGraphNode(x.label));
                }
                //add x's neighbor's copy to x's copy
                UndirectedGraphNode xCopy = table.get(x);
                table.get(p).neighbors.add(xCopy);
            }
        }
        return root; 
        */
        
        //version 2: DFS
        if(node == null){
            return null;
        }
        Hashtable<UndirectedGraphNode, UndirectedGraphNode> table = new Hashtable<>();
        return dfs(node, table);
        
        /*
        //version 3: 2 passes: clones nodes first, then neighbors; use a list's size to control the loop; from 9chap
                if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes    
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
        */
    }
    
    //version 2
    //return a copy of a node
    private UndirectedGraphNode dfs(UndirectedGraphNode node, Hashtable<UndirectedGraphNode, UndirectedGraphNode> table){
        //if the table already contains a node (it's dealt before, including neighbors), return the copy directly
        if(table.containsKey(node)){
            return table.get(node);
        }
        //the first time you encounter a node, create a copy and deal with its neighbors
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        table.put(node, nodeCopy);
        for(UndirectedGraphNode x : node.neighbors){
            table.get(node).neighbors.add(dfs(x, table));
        }
        return nodeCopy;
    }
}