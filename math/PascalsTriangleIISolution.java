public class PascalsTriangleIISolution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0){
            return result;
        }
        //(i, j) from (i - 1, j - 1) and (i - 1, j)
        //note rowIndex = 0 -> [1]
        result.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                if(j == i){
                    result.add(1);
                }else{
                    result.set(j, result.get(j) + result.get(j-1));
                }
            }
        }
        return result;
    }
}