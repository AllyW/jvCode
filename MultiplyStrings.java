/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:

    The numbers can be arbitrarily large and are non-negative.
    Converting the input string to integer is NOT allowed.
    You should NOT use internal library such as BigInteger.

*/
import java.util.*;
import java.io.*;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
        if(num1.length() == 0 && num2.length() == 0) return "";
        int M = num1.length();
        int N = num2.length();
        int ML = M+N;
        int[] r = new int[ML];
        for(int i = M-1; i>= 0; i--){
            int n1 = num1.charAt(i) - '0';
            for(int j = N-1; j>= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int adds = n1 * n2;
                r[(N-1-j)+(M-1-i)] += adds;
                r[(N-1-j)+(M-1-i) + 1] += r[(N-1-j)+(M-1-i)]/10;
                r[(N-1-j)+(M-1-i)] = r[(N-1-j)+(M-1-i)]%10;
            }
        }
        String res = "";
        int i = ML-1;
        while(i >= 0 && r[i] == 0) i--;
        for(; i > 0; i--){
            res += r[i] + "";
        }
        return res + r[0] + "";  
	}	

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter number 1: ");
		String s = reader.nextLine();
		System.out.println("Enter number 2: ");
		String t = reader.nextLine();
		String res = multiply(s, t);
		System.out.println("number 1: " + s);
		System.out.println("number 2: " + t);
		System.out.println("result: " + res);
		return;
	}	
}
