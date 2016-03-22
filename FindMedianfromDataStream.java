/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
Examples:

[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.

For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2

*/

// note: any class is a set of variables and functions.
// search here is search for a string that starts from the root and must end with the root's endpoint
import java.io.*;
import java.util.*;
public class FindMedianfromDataStream {
	public static class MedianFinder {
	    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue();
    
	    // Adds a number into the data structure.
		public void addNum(int num) {
			large.add((long)num);
	        small.add(-large.poll());
		    if(large.size() < small.size()){
			    large.add(-small.poll());
	        }
	    }

	    // Returns the median of current data stream
		public double findMedian() {
			if(large.size() == small.size()){
				return (large.peek() - small.peek())/2.0;
	        }else{
		        return large.peek();
	        }
	    }
	};	

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

	public static void main(String[] args) { 
		MedianFinder mf = new MedianFinder();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Add a number: ");
		while(reader.hasNextInt()){
			int n = reader.nextInt();
			mf.addNum(n);
			System.out.println("Median number:" + mf.findMedian());
		}
		return;
	}	
}
