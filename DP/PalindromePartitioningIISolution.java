public class PalindromePartitioningIISolution {
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }
        boolean[][] isPalindrome = getPalindrome(s);
        int n = s.length();
        //each element at index i: minimum cut from index 0 to i
        int[] partition = new int[n+1];
        for(int i = 0; i < n + 1; i++){
            partition[i] = i - 1;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < i; j++){
            	//remember there is 1 difference between partition and isPalindrome array
            	//j+1 in partition corresponds to j in isPalindrome
                if(isPalindrome[j][i-1] && partition[j] + 1 < partition[i]){
                    partition[i] = partition[j] + 1;
                }
            }
        }
        return partition[n];
    }
    public boolean[][] getPalindrome(String s){
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++){
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1) ? true : false;
        }
        for(int length = 2; length < n; length++){
            for(int i = 0; i + length < n; i++){
                isPalindrome[i][i+length] = isPalindrome[i+1][i+length-1] && s.charAt(i) == s.charAt(i+length);
            }
        }
        return isPalindrome;
    }
}