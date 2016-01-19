public class WordLadderSolution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList.size() == 0){
            return 0;
        }
        HashSet<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        String word = beginWord;
        if(word.equals(endWord)){
            return 1;
        }
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                word = queue.poll();
                for(String x : getNeighbors(word, wordList)){
                    if(!set.contains(x)){
                        queue.offer(x);
                        set.add(x);
                        if(x.equals(endWord)){
                            return level + 1;
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
    
    private ArrayList<String> getNeighbors(String word, Set<String> wordList){
        ArrayList<String> result = new ArrayList<String>();
        for(int j = 0; j < word.length(); j++){
            char x = word.charAt(j);
            for(char k = 'a'; k <= 'z'; k++){
                if(x != k){
                    String replacement = helper(word, j, k);
                    if(wordList.contains(replacement)){
                        result.add(replacement);
                    }
                }
            }
        }
        return result;
    }
    
    //replace a character in the string at index i
    //if using substring to do this, time limit exceeded
    private String helper(String oldString, int index, char c){
        char[] chars = oldString.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}