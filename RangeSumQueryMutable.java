/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:

    The array is only modifiable by the update function.
    You may assume the number of calls to update and sumRange function is distributed  *evenly*.

*/


public class RangeSumQueryMutable {

/*
	public static class NumArray {    // TLE 
		private int[] sum;   
	    public NumArray(int[] nums) {   //O(n) space and time
		    int L = nums.length;
			sum = new int[L+1];
	        sum[0] = 0;
		    for(int i = 1; i<= L; i++){
			    sum[i] = sum[i-1] + nums[i-1];
	        }
		}

		void update(int i, int val) { //O(n) time
			int d = val - (sum[i+1] - sum[i]);
	        for(int j = i+1; j< sum.length; j++){
		        sum[j] += d;
			}
	    }

		public int sumRange(int i, int j) { // O(1) time
			return sum[j+1]-sum[i];
		 }
	}

*/

	public static class NumArray{
		class SegmentTreeNode {
	        int start, end;
		    SegmentTreeNode left, right;
			int sum;

	        public SegmentTreeNode(int start, int end) {
		        this.start = start;
			    this.end = end;
				this.left = null;
	            this.right = null;
		        this.sum = 0;
			}
	    }

		SegmentTreeNode root = null;

	    public NumArray(int[] nums) {
		    root = buildTree(nums, 0, nums.length-1);
	    }

	    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		    if (start > end) {
			    return null;
	        } else {
		        SegmentTreeNode ret = new SegmentTreeNode(start, end);
			    if (start == end) {
				    ret.sum = nums[start];
	            } else {
		            int mid = start  + (end - start) / 2;             
			        ret.left = buildTree(nums, start, mid);
     				ret.right = buildTree(nums, mid + 1, end);
				    ret.sum = ret.left.sum + ret.right.sum;
	            }         
		        return ret;
			}
	    }

	   void update(int i, int val) {
		    update(root, i, val);
	    }

		void update(SegmentTreeNode root, int pos, int val) {
			if (root.start == root.end) {
				root.sum = val;
	        } else {
		        int mid = root.start + (root.end - root.start) / 2;
			    if (pos <= mid) {
				     update(root.left, pos, val);
	            } else {
		             update(root.right, pos, val);
			    }
				root.sum = root.left.sum + root.right.sum;
	        }
		}

	    public int sumRange(int i, int j) {
		    return sumRange(root, i, j);
	    }

		public int sumRange(SegmentTreeNode root, int start, int end) {
			if (root.end == end && root.start == start) {
				return root.sum;
	        } else {
		        int mid = root.start + (root.end - root.start) / 2;
			    if (end <= mid) {
				    return sumRange(root.left, start, end);
	            } else if (start >= mid+1) {
		            return sumRange(root.right, start, end);
			    }  else {    
				    return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
	            }
		    }
	    }
	}


	// method 1: segment tree: http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
	// method 2: binary indexed tree or fenwick tree:
	// http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
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
