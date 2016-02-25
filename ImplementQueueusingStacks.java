/*
 Implement the following operations of a queue using stacks.

    push(x) -- Push element x to the back of queue.
    pop() -- Removes the element from in front of queue.
    peek() -- Get the front element.
    empty() -- Return whether the queue is empty.

Notes:

    You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
    You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

*/

import java.util.*;
import java.io.*;

public class ImplementQueueusingStacks {
	public static class MyQueue {
		Stack<Integer> queue = new Stack<Integer>();
		Stack<Integer> cp = new Stack<Integer>();
        // Push element x to the back of queue.
		public void push(int x) {
			while(!cp.empty()){
				queue.push(cp.pop());
			}
			queue.push(x);
			while(!queue.empty()){
				cp.push(queue.pop());
			}	
        
		}

		// Removes the element from in front of queue.
		public void pop() {
		    while(!queue.empty()){
		        queue.pop();
			}
	        cp.pop();
		    while(!cp.empty()){
			    queue.push(cp.pop());
		    }
			while(!queue.empty()){
				cp.push(queue.pop());
		    }
		}

	    // Get the front element.
		public int peek() {
			return cp.peek();
	    }

	    // Return whether the queue is empty.
		public boolean empty() {
			return cp.size() == 0? true: false;
		}
	}

	
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.push(5);
		q.push(4);
		q.push(3);
		System.out.println("current top is " + q.peek());
		System.out.println("is empty?  " + q.empty());
		return;
	}	
}
