public class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        /* //version 1: remove one char in each loop
        String prefix = strs[0];
        //use strs[0] as prefix and check if all other strings have it as prefix; if not, remove last char and try; repeat
        while(prefix.length() > 0){
            int n = prefix.length();
            for(int i = 1; i < strs.length; i++){
                if(strs[i].length() < n || strs[i].length() >= n && !prefix.equals(strs[i].substring(0,n))){
                    prefix = prefix.substring(0, prefix.length() - 1);
                    break;
                }
            }
            if(n == prefix.length()){
                return prefix;
            }
        }
        return "";
        */
        //version 2: keep as many as chars in prefix string as possible in each loop
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)){
                j++;
            }
            //could also check whether j == 0 return ""
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}