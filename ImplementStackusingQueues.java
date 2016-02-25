/*
 Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.

Notes:

    You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack. 
*/

import java.util.*;
import java.io.*;

public class ImplementStackusingQueues {
	public static class MyStack {
    private Queue<Integer> st = new LinkedList<Integer>();
    private Queue<Integer> cp = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if(cp.isEmpty()){
            st.add(x);
        }else{
            cp.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(cp.isEmpty()){
            while(st.size()>1){
                cp.add(st.poll());
            }
            st.poll();
        }else{
            while(cp.size()>1){
                st.add(cp.poll());
            }
            cp.poll();
        }
        
    }

    // Get the top element.
    public int top() {
        if(cp.isEmpty()){
            while(st.size()>1){
                cp.add(st.poll());
            }
             int x = st.poll();
             cp.add(x);
             return x;
        }else{
            while(cp.size()>1){
                st.add(cp.poll());
            }
            int x = cp.poll();
            return x;
        }
        
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(cp.isEmpty() && st.isEmpty()) return true;
        return false;
        
    }
}
	
	public static void main(String[] args) {
		MyStack st = new MyStack();
		st.push(5);
		st.push(4);
		st.push(3);
		System.out.println("current top is " + st.top());
		System.out.println("pop top");
		st.pop();
		System.out.println("current top is " + st.top());
		System.out.println("is empty?  " + st.empty());
		return;
	}	
}
