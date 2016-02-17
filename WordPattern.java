/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 
*/

import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map; //use hashmap or hashtable

public class WordPattern {
	public static boolean solution1(String pattern, String str) {
        if(str.length() <= 0 || pattern.length() <= 0) return false;
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        int L = pattern.length();   // array.length, string.length()
        Hashtable<Character, String> pm = new Hashtable<Character, String>();
        for(int i = 0; i < L; i++){
            char c = pattern.charAt(i);
            if(pm.containsKey(c)){
                if(!pm.get(c).equals(words[i])) return false;
            }else if(pm.contains(words[i])){ 
                return false;
            }else{
                pm.put(c, words[i]);
            }
        }
        return true;    
	}

	public static boolean solution2(String pattern, String str) {
        if(str.length() <= 0 || pattern.length() <= 0) return false;
        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;
        int L = pattern.length();   // array.length, string.length()
        Map<Character, String> pm = new HashMap<Character, String>();  
        for(int i = 0; i < L; i++){
            char c = pattern.charAt(i);
            if(pm.containsKey(c)){
                if(!pm.get(c).equals(words[i])) return false;
            }else if(pm.containsValue(words[i])){ 
                return false;
            }else{
                pm.put(c, words[i]);
            }
        }
        return true;    
	}


	public static void main(String[] args) {
		String p = "abba";
		String s = "dog dog cat cat";
        boolean res1 = solution1(p, s);
        boolean res2 = solution2(p, s);
        System.out.println("Pattern: " + p);
        System.out.println("Words: " + s);
        System.out.println("Result using solution 1: " + res1);
        System.out.println("Result using solution 2: " + res2);
		return;
	}	
}
