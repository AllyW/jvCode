/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
*/

import java.io.*;
import java.util.*;

public class CountandSay {
	public static String countAndSay(int n) {
		if(n <= 0) return "";
		int a = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		StringBuilder pre = new StringBuilder();
		while(a < n){
			pre = sb;
			int count = 1;
			int L = pre.length();
			sb = new StringBuilder();
			char say = pre.charAt(0);
			for(int i = 1; i < L; i++){
				if(pre.charAt(i) != say){
					sb.append(count).append(say);
					say = pre.charAt(i);
					count= 1;
				}else{
					count++;
				}
			}
			sb.append(count).append(say);
			a++;
		}
		return sb.toString();
	}	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		String res = countAndSay(n);
		System.out.println("the nth string: " + res);
		return;
	}	
}
