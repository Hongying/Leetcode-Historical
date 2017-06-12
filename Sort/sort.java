/*
https://www.lintcode.com/en/problem/sort-integers-ii/
*/
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // merge sort
        if(A == null || A.length == 0){
            return;
        }
        mergeSort(A, 0, A.length-1);
    }
    public void mergeSort(int[] A, int begin, int end){
        if(begin >= end){
            return;
        }
        int mid = (end - begin)/2 + begin;
        mergeSort(A, begin, mid);
        mergeSort(A, mid + 1, end);
        //merge two sorted partial arrays, using another helper array
        int i = begin, j = mid + 1;
        int[] B = new int[end - begin + 1];
        int k = 0;
        
        while(i <= mid && j <= end){
            if(A[i] <= A[j]){
                B[k] = A[i];
                i++;
            }else{
                B[k] = A[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            B[k] = A[i]; k++; i++;
        }
        while(j <= end){
            B[k] = A[j]; k++; j++;
        }
        
        for(i = begin, k = 0; i <= end; i++, k++){
            A[i] = B[k];
        }
    }
}