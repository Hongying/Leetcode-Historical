public class UglyNumberSolution {
    public boolean isUgly(int num) {
        /*
        //version 1: time limit exceeded
        if(num < 1){
            return false; 
        }
        if(num == 1){
            return true;
        }
        boolean[] nums = new boolean[num+1];
        nums[1] = true;
        for(int i = 1; i < num + 1; i++){
            if(nums[i] == true){
                if(2 * i < num + 1){
                    nums[2 * i] = true;
                }
                if(3 * i < num + 1){
                    nums[3 * i] = true;
                }
                if(5 * i < num + 1){
                    nums[5 * i] = true;
                }
            }
        }
        return nums[num];
        */
        //version 2 
        if(num <= 0){
            return false;
        }
        while(num % 2 == 0){
            num = num / 2;
        }
        while(num % 3 == 0){
            num = num / 3;
        }
        while(num % 5 == 0){
            num = num / 5;
        }
        if(num == 1){
            return true;
        }
        return false;
    }
}