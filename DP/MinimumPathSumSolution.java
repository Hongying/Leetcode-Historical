public class MinimumPathSumSolution {
    public int minPathSum(int[][] grid) {
        /*
        //version 1
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        if(m == 0){
            return 0;
        }
        int n = grid[0].length;
        int[][] mem = new int[m][n];
        for(int[] x : mem){
            Arrays.fill(x, -1);
        }
        return helper(grid, mem, m-1, n-1);
        */
        //version 2: without recursion
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        return sum[M - 1][N - 1];
    }
    /*
    //version 1
    //from 0, 0 to x, y minPathSum; if not using mem, time limit exceed
    private int helper(int[][] grid, int[][] mem, int x, int y){
        if(x == 0 && y == 0){
            return grid[0][0];
        }
        if(mem[x][y] != -1){
            return mem[x][y];
        }
        //note here initialization of result not 0
        int result = Integer.MAX_VALUE;
        if(x - 1 >= 0){
            result = helper(grid, mem, x-1, y) + grid[x][y];
        }
        if(y - 1 >= 0){
            result = Math.min(result, helper(grid, mem, x, y-1) + grid[x][y]);
        }
        mem[x][y] = result;
        return result;
    }
    */
}