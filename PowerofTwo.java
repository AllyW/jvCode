/*
Given an integer, write a function to determine if it is a power of two. 
*/

import java.io.*;
import java.util.*;

public class PowerofTwo{
	public static boolean isPowerOfTwo(int n) {
        return n > 0 && 1073741824 % n == 0 ? true: false;  // the biggest power of 2 in integer: 2^30
        
    }
	public static boolean isPowerOfTwo2(int n) {
        int mod = 0;
        while(n >= 2){
            mod = n % 2;
            if(mod != 0) return false;
            n = n /2;
        }
        if(n == 1) return true;
        return false;
    }

	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3};
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		System.out.println("is Power of two? ");
		System.out.println("method 1:" + isPowerOfTwo(n));
		System.out.println("method 2:" + isPowerOfTwo2(n));
		return;
	}	
}
