/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/
import java.io.*;
import java.util.*;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
        if(t.length() <=0) return true;
        if(s.length() <=0) return false;
        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        for(int i = 0; i < ts.length; i++){
            if(ss[i] !=  ts[i]){
                return false;
            }
        }
        return true;
    }	

	public static void main(String[] args) {
		String s = "cart";
		String t = "ctra";
		boolean res = isAnagram(s, t);
		System.out.println("Source string: " + s);
		System.out.println("Target string: " + t);
		System.out.println("Is anagram: " + res);
		return;
	}	
}
