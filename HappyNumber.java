/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
 
*/

import java.io.*;
import java.util.*;

public class HappyNumber {
	public static boolean isHappy(int n) {
        if(n == 1) return true;
        int res1 = 0;
        int res2;
        Set<Integer> sum = new HashSet<Integer>();
        while(sum.add(n)){
            res2 = res1;
            res1 = 0;
            while(n >= 10){
                res1 += Math.pow(n%10, 2);
                n = n/10;
            }
            res1 += Math.pow(n, 2);
            if(res1 == res2) return false;
            if(res1 == 1) return true;
            n = res1;
        }
        
        return false;
	}
    
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		boolean res = isHappy(n);
		System.out.println("Happy Number? " + res);
		return;
	}	
}
