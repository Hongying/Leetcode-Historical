public class BullsAndCowsSolution {
    public String getHint(String secret, String guess) {
        /* 
        //version 1: use hashmap to record and compare
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        boolean[] checked = new boolean[secret.length()];
        for(int i = 0; i < secret.length(); i++){
            char temp1 = secret.charAt(i);
            char temp2 = guess.charAt(i);
            if(temp1 == temp2){
                bulls++;
                checked[i] = true;
            }else{
                if(!map.containsKey(temp1)){
                    map.put(temp1,1);
                }else{
                    map.put(temp1, map.get(temp1) + 1);
                }
            }
        }
        //compare guess's unchecked chars with those stored in map (secret unchecked chars)
        for(int i = 0; i < secret.length(); i++){
            if(checked[i] == false){
                char temp2 = guess.charAt(i);
                if(map.containsKey(temp2)){
                    cows++;
                    map.put(temp2, map.get(temp2) - 1);
                    if(map.get(temp2) == 0){
                        map.remove(temp2);
                    }
                }
            }
        }
        return bulls + "A" + cows + "B";
        */
        //version 2: use an int array to record
            int bull = 0, cow = 0;
            int[] array = new int[10];
        
            for(int i = 0; i < secret.length(); i++) {
                char s = secret.charAt(i);
                char g = guess.charAt(i);
                if(s == g){
                    bull++;
                }else {
                    if(array[s - '0'] < 0) {
                        cow++;
                    }
                    array[s - '0']++;
        
                    if(array[g - '0'] > 0) {
                        cow++;
                    }
                    array[g -'0']--;
                }
            }
            return bull + "A" + cow + "B";
    }
}