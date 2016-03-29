/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 0) return 0;
        int L = s.length();
        int res = 0;
        int j = 0;
        Map<Character, Integer> hp = new HashMap<Character, Integer>();
        for(int i = 0; i < L; i++){
            if(hp.containsKey(s.charAt(i))){
                j = Math.max(j, hp.get(s.charAt(i))+1);
            }
            hp.put(s.charAt(i), i);
            res = Math.max(res, i-j+1);
        }
        return res;
    }	

	public static void main(String[] args) {
		String s = "abcabscccc";
		int res = lengthOfLongestSubstring(s);
		System.out.println("Source string: " + s);
		System.out.println("length of longest pali substring: " + res);
		return;
	}	
}
