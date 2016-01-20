public class NimGameSolution {
    public boolean canWinNim(int n) {
        /*
        //version 1: DP: time limit exceeded
        if(n <= 3){
            return true;
        }
        boolean a = true;
        boolean b = true;
        boolean c = true;
        for(int i = 4; i < n+1; i++){
            boolean temp = true;
            if(a && b && c){
                temp = false;
            }
            a = b;
            b = c;
            c = temp;
        }
        return c;
        */
        //version 2
        return n % 4 != 0;
    }
}