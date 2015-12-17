public class WordBreakSolution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        /*
        //version 1: can find out whether any substring of s can be broken into words
        //start from substrings of smaller length to longer length
        if(s == null || s.length() == 0){
            return false;
        }
        int n = s.length();
        //mem[i][j]: whether s.substring(i,j+1) can be broken into words
        boolean[][] mem = new boolean[n][n];
        for(int i = 0; i < n; i++){
            mem[i][i] = wordDict.contains(s.substring(i,i+1));
        }
        for(int length = 2; length <= n; length++){
            for(int i = 0; i + length <= n; i++){
                    if(wordDict.contains(s.substring(i, i + length))){
                        mem[i][i+length-1] = true;
                        continue;
                    }
                    //for element from index i to i+length-1, try each possible break position
                    for(int j = 0; j < length - 1; j++){
                        if(mem[i][i+j] == true && mem[i+j+1][i+length-1] == true){
                            mem[i][i+length-1] = true;
                            break;
                        }
                    }
            }
        }
        return mem[0][n-1];
        */
        
        //version 2: can find out whether any substring of s can be broken into words
        //start from substrings of smaller length to longer length
        //add 1 more line/row (a dummy character) so don't need to take the if case in the second loop specially as in version 1
        //also modify i+length to be the end index in the array (i.e. current string index + 1)
        if(s == null || s.length() == 0){
            return false;
        }
        int n = s.length();
        //mem[i][j]: whether s.substring(i,j+1) can be broken into words
        boolean[][] mem = new boolean[n + 1][n + 1];
        mem[0][0] = true;
        for(int i = 1; i < n + 1; i++){
            mem[i][i] = wordDict.contains(s.substring(i-1,i));
        }
        //start from substring length = 2 (count the dummy character as well)
        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length < n + 1; i++){
                    //for element from index i to i+length (in the array), try each possible break position
                    for(int j = i; j < i + length; j++){
                        if(mem[i][j] && wordDict.contains(s.substring(j, i + length))){
                            mem[i][i + length] = true;
                            break;
                        }
                    }
            }
        }
        //remember to return mem[0][n], not mem[1][n]! 
        return mem[0][n];
        
        /*
        //version 3: only find out whether s, or from index 0 to any index can be broken into words
        //start from smaller index to bigger index
        if(s == null || s.length() == 0){
            return false;
        }
        int n = s.length();
        //mem[i] is true if s.substring(0,i+1) can be broken into words
        boolean[] mem = new boolean[n + 1];
        mem[0] = true;
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < i; j++){
                //note that mem index is bigger than s index by 1
                if(mem[j] && wordDict.contains(s.substring(j,i))){
                    mem[i] = true;
                    break;
                }
            }
        }
        return mem[n];
        */
    }
}