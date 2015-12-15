/**
*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
*
*For example, given the following triangle
*[
*     [2],
*    [3,4],
*   [6,5,7],
*  [4,1,8,3]
*]
*The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

public class TriangleSolution {
    //top down version
    //other ways: bottom up; recursive + memorize 
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        if (triangle.get(0) == null || triangle.get(0).size() == 0) {
            return -1;
        }
        int n = triangle.size();
        //stores the minimum total for each row; keep being updated in a loop
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++){
            //deal with ith row; the first elt. and the last elt. in each row needs to be taken care of specially +
            //they can only form a path with the first elt. and last elt. in the triangle
            for(int j = i; j >= 0; j--){
                if(j == i){
                    result[j] = triangle.get(i).get(j) + result[j-1];
                }else if(j == 0){
                    result[j] = triangle.get(i).get(j) + result[0];
                }else{
                    result[j] = Math.min(result[j],result[j-1]) + triangle.get(i).get(j);
                }
            }
        }
        //if consider the triangle as a tree, the result stores the minimum of reaching from root to each leaf.
        int min = result[0];
        for(int i : result){
            if(i < min){
                min = i;
            }
        }
        return min;
    }
}