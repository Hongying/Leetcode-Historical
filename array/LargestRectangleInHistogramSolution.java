public class LargestRectangleInHistogramSolution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        //version 1 brute force O(n^2), fix a index and expand to both sides to find the edge of the rectangle
        /*
        int area = 0;
        for(int i = 0; i < heights.length; i++){
            int left = i;
            while(left >= 0 && heights[left] >= heights[i]){
                left--;
            }
            left++;
            int right = i;
            while(right < heights.length && heights[right] >= heights[i]){
                right++;
            }
            right--;
            area = Math.max(area, heights[i] * (right - left + 1));
        }
        return area;
        */
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            /* after you pop an elt. (current elt.), the 1st elt. < it on its left is the current top;
            the 1st. elt. on the right < it is heights[i] because only when heights[i] < it, we popped the current elt.
            */
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int top = stack.pop();
                area = Math.max(area, heights[top] * (i - 1 - (stack.peek() + 1) + 1));
            }
            //don't forget to push
            stack.push(i);
        }
        while(stack.size() > 1){
            int x = stack.pop();
            area = Math.max(area, (heights.length - 1 - (stack.peek() + 1) + 1) * heights[x]);
        }
        return area;
    }
}