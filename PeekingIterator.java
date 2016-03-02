/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Follow up: How would you extend your design to be generic and work with all types, not just integer?
*/

import java.util.*;
import java.io.*;

public class PeekingIterator {
	// Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	public static class PeekingIteratorImp implements Iterator<Integer> {
		Integer curr;
		Iterator<Integer> it;
		public PeekingIteratorImp(Iterator<Integer> iterator) {
	    // initialize any member here.
		    it = iterator;
		    if(it.hasNext()) {
			    curr = it.next();
		    }else{
		        curr = null;
		    }
		}

		// Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
			return curr;
        
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    Integer peek = curr;
			if(it.hasNext()) {
				curr = it.next();
		    }else{
		        curr = null;
		 }
			return peek;
		}

		@Override
		public boolean hasNext() {
			return curr == null? false: true;
	    
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		System.out.print("Original contents of al: ");
        Iterator<Integer> itr = al.iterator();
		PeekingIteratorImp pitr = new PeekingIteratorImp(itr);
        //while(itr.hasNext()) {
          // Object element = itr.next();
           //System.out.print(element + " ");
        //}
        System.out.println();
		while(pitr.hasNext()){
           Object element = pitr.next();
		   Integer peek =  pitr.peek();
           System.out.print("element: " + element + " peek:" + peek + ", ");
		}
 	 	return;
	}	
}
