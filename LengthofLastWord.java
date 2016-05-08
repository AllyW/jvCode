/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. 
*/

import java.util.*;

public class LengthofLastWord {
	public static int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return s.charAt(0) != ' ' ? 1:0;
        int L = s.length();
        int i = L-1;
        int a = L-1;
        while( i >= 0 && s.charAt(i) == ' ') i--;
        a = i;
        while(i>=0 && s.charAt(i) != ' ') i--;
        return a-i;
    }	
	public static void main(String[] args) {
		String s = " hello world     ";
		System.out.println("string: " + s);
		int res = lengthOfLastWord(s);
		System.out.println("the last word's length: " + res);
		return;
	}	
}
