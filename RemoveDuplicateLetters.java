/*
 Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:

Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb" 
*/
import java.util.*;

public class RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {
        if(s.length() <= 0) return "";
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(pos)) pos = i;
            if(--counts[s.charAt(i) - 'a'] == 0) break;  // find the smallest letter from left to right until a letter reaches its last index
            // meaning it cannot be readd later, meaning the smallest letter must be added before the reach-last-index letter
            // but the reach-last-index letter cannot be added because there might be another letter smaller than it but before it.
        }
        if(s.length() == 0){
            return "";
        }else{
            return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
        }
        
    }
	public static void main(String[] args) {
		String s = "cbacdcbc";
		String res = removeDuplicateLetters(s);
		System.out.println("String: " + s);
		System.out.println("Remove duplicates, reserve the order with smallest order in dictionary: " + res);
		return;
	}	
}
