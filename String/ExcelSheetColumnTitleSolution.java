public class ExcelSheetColumnTitleSolution {
    public String convertToTitle(int n) {
        if(n == 0){
            return "";
        }
        String result = "";
        //e.g. x * 26 * 26 + y * 26 + z; the following loop gets z, y, x then n-1 is 0~25 corresponds to A to Z
        //need to do (n-1)/26 because originally x, y, z ranges 1~26, if not (n-1), e.g. 26 -> "AZ"
        while(n > 0){
            char c = (char)('A' + (n - 1) % 26);
            result = c + result;
            n = (n - 1) / 26;
        }
        return result;
    }
}