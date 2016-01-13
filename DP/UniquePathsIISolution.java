public class UniquePathsIISolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 1? 0 : 1;
        for(int i = 1; i < m; i++){
            path[i][0] = obstacleGrid[i][0] == 1 ? 0 : path[i-1][0];
        }
        /* or
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break; //so every cell's value is 0 afterwards
            }
        }
        */
        
        for(int i = 1; i < n; i++){
            path[0][i] = obstacleGrid[0][i] == 1 ? 0 : path[0][i-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                path[i][j] = obstacleGrid[i][j] == 1 ? 0 : path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}