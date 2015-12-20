public class InterleavingStringSolution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //need s3.length() == 0 to deal with s3.equals("") case. Otherwise need to do isIL[0][0] = true;
        if(s3 == null || s3.length() == 0){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        int len = s3.length();
        //note: it is important to check the following
        if(len != m + n){
            return false;
        }

        //isIL[i][j] represents whether s1.substring(0,i) and s2.substring(0,j) can form s3.substring(0,i+j-1)
        boolean[][] isIL = new boolean[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++){
            //also could use: if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0]); need to set isIL[0][0] to true;
            isIL[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for(int i = 1; i < n + 1; i++){
            isIL[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(isIL[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                (isIL[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))){
                    isIL[i][j] = true;
                }
            }
        }
        return isIL[m][n];
    }
}