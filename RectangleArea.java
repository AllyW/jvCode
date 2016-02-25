/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area 
rectangle 1:(A, B), (C, D)
rectangle 2:(E, F), (G, H)

Assume that the total area is never beyond the maximum possible value of int.

*/

//boring
public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = Math.abs(C-A) * Math.abs(D-B);
        int area2 = Math.abs(G-E) * Math.abs(H-F);
        int lw, rw, bh, th;
        if(E <= A){
            lw = A;
        }else if(E > A && E <= C){
            lw = E;
        }else{
            return area1 + area2;
        }
        rw = Math.min(C, G);
        if(F <= B){
            bh = B;
        }else if( F > B && F <= D){
            bh = F;
        }else{
            return area1 + area2;
        }
        th = Math.min(D, H);
        if(lw > rw || bh > th) return area1 + area2;
        return area1 + area2 - (th - bh) * (rw - lw);
    }

	
	public static void main(String[] args) {
		return;
	}	
}
