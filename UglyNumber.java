/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 
*/

import java.io.*;
import java.util.*;

public class UglyNumber {
	public static boolean isUgly(int num) {
        if(num == 1) return true;
        if(num == 0) return false;
        while(num%2 == 0) num = num/2;
        while(num%3 == 0) num= num/3;
        while(num%5 == 0) num = num/5;
        return num==1;
    }
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		boolean res = isUgly(n);
		System.out.println("Ugly number? " + res);
		return;
	}	
}
