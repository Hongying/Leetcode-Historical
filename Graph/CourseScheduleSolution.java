import java.util.HashMap;
public class CourseScheduleSolution {
    /*try to do a topological sort, if it can be done, then return true; if not, return false;
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      if(numCourses == 0 || prerequisites.length == 0){
          return true;
      }
      //each elt. is <node, indegree>
      HashMap<Integer,Integer> degrees = new HashMap<>(); 
      for(int[] x : prerequisites){
          if(!degrees.containsKey(x[1])){
              degrees.put(x[1],1);
          }else{
              degrees.put(x[1],degrees.get(x[1]) + 1);
          }
      }
      //BFS
      //initialization the queue: put nodes with in-degree = 0 in the queue
      Queue<Integer> queue = new LinkedList<>();
      for(int i = 0; i < numCourses; i++){
          if(!degrees.containsKey(i)){
              queue.offer(i);
          }
      }
      List<Integer> result = new ArrayList<>();
      while(!queue.isEmpty()){
          Integer node = queue.poll();
          result.add(node);
          for(int[] x : prerequisites){
              if(node == x[0]){
                  degrees.put(x[1], degrees.get(x[1]) - 1);
                  if(degrees.get(x[1]) == 0){
                      degrees.remove(x[1]);
                      queue.offer(x[1]);
                  }
              }
          }
      }
      //or return degrees.isEmpty();, no need of result variable
      return (result.size() == numCourses);
    }
}