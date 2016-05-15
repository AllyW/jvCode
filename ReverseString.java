/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh". 
*/
import java.util.*;
import java.io.*;

public class ReverseString {
	public static String reverseString(String s) {
        char[] c = s.toCharArray();
        for (int i=0,j=c.length-1;i<j;i++,j--){
            char temp = c[i];
            c[i]=c[j];
            c[j]=temp;
        }
        return new String(c);
    }	

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String input = reader.nextLine();
		String res = reverseString(input);
		System.out.println("Source string: " + input);
		System.out.println("Reverse string: " + res);
		return;
	}	
}
