/*
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

    The number of buildings in any input list is guaranteed to be in the range [0, 10000].
    The input list is already sorted in ascending order by the left x position Li.
    The output list must be sorted by the x position.
    There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

*/

import java.io.*;
import java.util.*;

public class TheSkylineProblem {
	public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        List<int[]> h = new ArrayList<int[]>();
        for(int[] b: buildings){
            h.add(new int[]{b[0], -b[2]});
            h.add(new int[]{b[1], b[2]});
        }
        Collections.sort(h, (a, b) -> {    
           if(a[0] != b[0]){
               return a[0] - b[0];    // a[0] < b[0] a is eariler
           }else{
               return a[1] - b[1];
           }
        });
        Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b-a)); // max heap
        pq.offer(0);
        int pre = 0;
        for(int[] ah: h){
            if(ah[1] < 0){
                pq.offer(-ah[1]);
            }else{
                pq.remove(ah[1]);
            }
            int cur = pq.peek();
            if(pre != cur){
                res.add(new int[]{ah[0], cur});
                pre = cur;
            }
        }
        return res;
        
    }
	public static void dispArray2D(int[][] res){
		for(int i = 0; i < res.length; i++){    
			for(int j = 0; j < res[i].length; j++){
				System.out.print(res[i][j] + " ");   // note: res[i][j]
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{2, 9, 10},
			{3, 7, 15},
			{5, 12, 12},
			{15, 20, 10},
			{19, 24, 8}
		};
		System.out.println("Matrix: ");
		dispArray2D(matrix);
		List<int[]> r = getSkyline(matrix);
		System.out.println("results: ");  // list print~~
		for(int i = 0; i < r.size(); i++){
			System.out.println(" left: " + r.get(i)[0] + " height: " + r.get(i)[1]);
		}
		return;
	}	
}
