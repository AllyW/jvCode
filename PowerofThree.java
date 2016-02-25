/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 

*/

import java.io.*;
import java.util.*;

public class PowerofThree{
	public static boolean isPowerOfThree1(int n) {
		// 1162261467 is 3^19,  3^20 is bigger than int
		// using the biggest power of 3 in int to mod n, as long as the 
		// number is power of three, mods would be larger than 0
		return ( n>0 &&  1162261467%n==0);
		
    }

	public static boolean isPowerOfThree2(int n) {
        int mod = 0;
        while(n >= 3){
            mod = n % 3;
            if(mod != 0) return false;
            n = n /3;
        }
        if(n == 1) return true;
        return false;
    }

	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3};
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		System.out.println("is Power of three? ");
		System.out.println("method 1:" + isPowerOfThree1(n));
		System.out.println("method 2:" + isPowerOfThree2(n));
		return;
	}	
}
