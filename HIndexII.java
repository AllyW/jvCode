/*
 Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

    Expected runtime complexity is in O(log n) and the input is sorted.

*/


import java.util.*;
public class HIndexII {
	public static int hIndex(int[] citations) {
        if(citations.length <= 0) return 0;
        int L = citations.length;
        int l = 0, r = L-1;
        int mid;
        while(l <= r){
            mid = l + (r-l)/2;
            if(citations[mid] == L - mid){
                return L-mid;
            }else if(citations[mid] < L-mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return L - l;
    }

// actually the lower bound of citation[index] >= L - index needs to be found.
// use the lower bound method in cpp
// https://leetcode.com/discuss/56109/space-easy-solution-with-detailed-explanations-java-python
	public static int hIndex2(int[] citations) {
        int len = citations.length;

        int first = 0;
        int mid;
        int count = len;
        int step;

        while (count > 0) {
            step = count / 2;
            mid = first + step;
            if (citations[mid] < len - mid) {
                first = mid + 1;
                count -= (step + 1);
            }
            else {
                count = step;
            }
        }

        return len - first;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 3, 5, 6};
        System.out.print("H index for: ");
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		int res = hIndex(nums);
        System.out.print("is: method 1 -> " + res);
		res = hIndex2(nums);
        System.out.print("; method 2 -> " + res);
		return;
	}	
}
