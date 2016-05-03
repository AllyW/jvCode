/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

import java.io.*;
import java.util.*;

public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
        int res = 0;
        while(n>=5){
            res += n/5;
            n /= 5;
        }
        return res;
    }

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: "); // test 704, 52
		int n = reader.nextInt();
		int r= trailingZeroes(n);
		System.out.println("number of trailing zeros for " + n +"! is " + r);
		return;
	}	
}
