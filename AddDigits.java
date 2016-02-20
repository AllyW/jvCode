/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 
 
*/

import java.io.*;
import java.util.*;

public class AddDigits {
	public static int addDigits(int num) {
        while(num >= 10){
            int res = 0;
            while(num >= 10){
                res += num % 10;
                num = num / 10;
            }
            num = res + num;
        }
        
        return num;
    }
//	https://en.wikipedia.org/wiki/Congruence_relation
	public static int addDigits2(int num) {
		return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int res = addDigits(n);
		System.out.println("Digits added: " + res);
		return;
	}	
}
