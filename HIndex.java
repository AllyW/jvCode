/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

    An easy approach is to sort the array first.
*/

import java.util.*;
public class HIndex {
	public static int hIndex(int[] citations) {
        if(citations.length <= 0) return 0;
        Arrays.sort(citations);
        int L = citations.length;
        int i;
        for(i = 0; i < L; i++){
            if(citations[i] >= L - i) {
                return L-i;
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {3, 0, 6, 1, 5};
        System.out.print("H index for: ");
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		int res = hIndex(nums);
        System.out.print("is " + res);
		return;
	}	
}
