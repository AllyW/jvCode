/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

*/
import java.util.*;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> hp = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            if(!hp.containsKey(s.charAt(i))){
                if(hp.containsValue(t.charAt(i))) return false;  // avoid two character in s map to one character in t
                hp.put(s.charAt(i), t.charAt(i));
            }else{
                if(hp.get(s.charAt(i)).equals(t.charAt(i))){
                    continue;
                }else{
                    return false;
                }       
            }
        }
        return true;
    }	
	
	public static void main(String[] args) {
		String s = "ab";
		String t = "aa";
		boolean res = isIsomorphic(s, t);
		System.out.println("Source string: " + s);
		System.out.println("Target string: " + t);
		System.out.println("Is isomorphic: " + res);
		s = "paper";
		t = "title";
		res = isIsomorphic(s, t);
		System.out.println("Source string: " + s);
		System.out.println("Target string: " + t);
		System.out.println("Is isomorphic: " + res);
		return;
	}	
}
