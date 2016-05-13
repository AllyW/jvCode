/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.
Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

*/

import java.io.*;
import java.util.*;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x<0 || (x!=0 && x%10==0)) return false;
		int rev = 0;
		while (x>rev){
			rev = rev*10 + x%10;
			x = x/10;
		}
		return (x==rev || x==rev/10);
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		boolean res = isPalindrome(n);
		System.out.println("Palindrome number: " + res);
		return;
	}	
}
