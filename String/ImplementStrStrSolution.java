public class ImplementStrStrSolution {
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null){
            return -1;
        }
        if(needle.equals("")){
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        for(int i = 0; i < m; i++){
            if(m - i < n){
                return -1;
            }
            for(int j = 0; j < n; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == n - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}