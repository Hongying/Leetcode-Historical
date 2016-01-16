public class PalindromePartitioningSolution {
    public List<List<String>> partition(String s) {
        //similar to subset 
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null){
            return result;
        }
        helper(s, new ArrayList<String>(), 0, result);
        return result;
    }
    
    //find palindrome strings started with path; when index is out of bound, add path to result and return
    public void helper(String s, List<String> path, Integer pos, List<List<String>> result){
        //previously s.length() == path.size: not right; e.g. s = "bb", path =["bb"]
        if(s.length() == pos){
            result.add(new ArrayList<String>(path));
            return;
        }
        //start from index pos, check whether the substring after it with 0, 1, 2, 3, ... chars is a palindrome or not, if yes, call helper recursively to get the palindromes after this substring 
        for(int i = pos + 1; i <= s.length(); i++){
            //check whether substring(pos,i) is palindrome or not
            if(!isPalindrome(s, pos, i - 1)){
                continue;
            }
            path.add(s.substring(pos,i));
            helper(s, path, i, result);
            path.remove(path.size() - 1);
        }
    }
    
    //check if s's substring from index start to end is palindrome
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}