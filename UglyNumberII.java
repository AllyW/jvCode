/*
 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number. 
*/

import java.io.*;
import java.util.*;

public class UglyNumberII {
	public static int nthUglyNumber(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int index2=0, index3=0, index5=0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            int minum = Math.min(Math.min(res[index2]*2, res[index3]*3), res[index5]*5);
            if(minum == res[index2]*2) {
                index2++;
            }
            if(minum == res[index3]*3){  
                index3++;
            }
            if(minum == res[index5]*5){
                index5++;
            }
            res[i] = minum;
        }
        return res[n-1];
    }	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int res = nthUglyNumber(n);
		System.out.println("The " + n + "th ugly number is: " + res);
		return;
	}	
}
