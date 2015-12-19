public class DistinctSubsequencesSolution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null){
            return -1;
        }   
        int m = s.length();
        int n = t.length();
        if(m < n){
            return 0;
        }
        int[][] f = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            f[i][0] = 1;
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                /*for cases that the character i and j are not different, the only way is 
                to have subsequences in s.substring(0,i-1)  */
                f[i][j] = f[i - 1][j];
                /*for cases that the character i and j are the same, add the number of 
                    subsequences of t.substring(0,j-1) in s.substring(0,i-1)   */
                if(s.charAt(i-1) == t.charAt(j-1)){
                    f[i][j] += f[i - 1][j - 1];
                }
            }
        }
        
        return f[m][n];
    }
}