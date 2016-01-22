public class RectangleAreaSolution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        /* //version 1
        if(A > E && C < G && B > F && D < H){
            return area2;
        }
        if(E > A && G < C && F > B && H < D){
            return area1;
        }
        */
        int area = area1 + area2 - overlapLength(A, C, E, G) * overlapLength(B, D, F, H);
        return area;
    }
    
    //find the length of the overlap edges
    //@param x1, x2 belongs to the first rectangle, y1, y2 belongs to the second rectangle; they either are for x coord. or y coord.
    private int overlapLength(int x1, int x2, int y1, int y2){
        if(x2 <= y1 || y2 <= x1){ //not overlapping
            return 0;
        }
        /* //version 1
        if(x1 > y1 && x2 < y2){
            return x2 - x1;
        }
        if(x1 < y1 && x2 > y2){
            return y2 - y1;
        }
        return Math.min(x2 - y1, y2 - x1);
        */
        //version 2
        return Math.min(x2, y2) - Math.max(x1, y1);
    }
}