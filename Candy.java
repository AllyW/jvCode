/*
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? 
*/

import java.util.*;

public class Candy {
	public static int candy(int[] ratings) {
        if(ratings.length <= 0) return 0;
        int s = ratings.length;
        if(s == 1) return 1;
        
        int[] candy = new int[s];
        candy[0] = 1;
        for(int i = 1; i < s; i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }else{
                candy[i] = 1;
            }
        }
        
        for(int i = s-2; i>= 0; i--){
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]){
                candy[i] = candy[i+1]+1;
            }
        }
        int res = 0;
        for(int i = 0; i < s; i++){
            res += candy[i];
        }
        return res;
    }	
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 4, 3, 3, 2, 5};
		int res = candy(nums1);
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
		System.out.println();
        System.out.println("Minimum candy: " + res);
		return;
	}	
}
