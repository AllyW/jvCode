/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.

*/


public class RangeSumQueryImmutable {
	public static class NumArray {
		private int[] ar;
		public NumArray(int[] nums) {
			ar = nums;
			for(int i = 1; i < nums.length; i++){
				ar[i] += ar[i-1];
			}
		}
		
		public int sumRange(int i, int j) {
			return i==0? ar[j]: ar[j] - ar[i-1];
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
		System.out.print( "Before: ");
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		NumArray a = new NumArray(nums);
		System.out.println("Sum between 0 and 5 is: " +a.sumRange(0, 5));
		System.out.println("Sum between 2 and 4 is: " +a.sumRange(2, 4));
		return;
	}	
}
