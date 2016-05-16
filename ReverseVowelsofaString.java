/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede". 
*/
import java.util.*;
import java.io.*;

public class ReverseVowelsofaString {
	public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int i = 0; 
        int j = s.length() - 1;
        while(i < j){
            while(i < j && vowels.indexOf(arr[i]) == -1) i++;
            while(i < j && vowels.indexOf(arr[j]) == -1) j--;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String input = reader.nextLine();
		String res = reverseVowels(input);
		System.out.println("Source string: " + input);
		System.out.println("Reverse vowels of string: " + res);
		return;
	}	
}
