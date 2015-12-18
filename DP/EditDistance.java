public class EditDistanceSolution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null){
            return -1;
        }
        int m = word1.length();
        int n = word2.length();
        //dist[i][j] is the distance between word1.substring(0,i) and word2.substring(0,j)
        int[][] dist = new int[m + 1][n + 1];
        //initialize the first row and column
        for(int i = 0; i < n + 1; i++){
            dist[0][i] = i;
        }
        for(int i = 1; i < m + 1; i++){
            dist[i][0] = i;
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dist[i][j] = dist[i-1][j-1];
                }else{
                    dist[i][j] = Math.min(dist[i-1][j-1],Math.min(dist[i-1][j],dist[i][j-1])) + 1;
                }
            }
        }
        return dist[m][n];
    }
}