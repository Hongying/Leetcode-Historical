public class WordPatternSolution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        if(pattern == null || str == null){
            return false;
        }
        int j = -1;
        for(int i = 0; i < pattern.length(); i++){
            char char_pattern = pattern.charAt(i);
            //get word with index = i from str
            j++;
            int oldJ = j;
            while(j < str.length() && str.charAt(j) != ' '){
                j++;
            }
            //if str shorter than pattern
            if(oldJ == j){
                return false;
            }
            String string_str = str.substring(oldJ, j);
            if(!map.containsKey(char_pattern)){
                //if 2 elt. in pattern both correspond to the same string in str
                if(map.containsValue(string_str)){
                    return false;
                }
                map.put(char_pattern, string_str);
            }else{
                if(!map.get(char_pattern).equals(string_str)){
                    return false;
                }
            }
        }
        //if pattern is shorter
        if(j != str.length()){
            return false;
        }
        return true;
    }
}