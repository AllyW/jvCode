/*
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:

Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:

Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words. 
*/

import java.util.*;

public class MaximumProductofWordLengths {
	public static int maxProduct(String[] words) {
        if(words.length <= 1) return 0;
        int  L = words.length;
        int res = 0;
        for(int i = 0; i < L; i++){
            for(int j = i+1; j < L; j++){
                if(hasCommonLetter(words[i], words[j]) == false){
                    res = Math.max(words[i].length()*words[j].length(), res);
                }
            }
        }
        return res;
        
    }
    
    public static boolean hasCommonLetter(String a, String b){
        int[] arr = new int[26];
        for(int i = 0; i < a.length(); i++){
            int p = a.charAt(i) - 'a';
            arr[p] = 1;
        }
        for(int i =0; i < b.length(); i++){
            int p = b.charAt(i) - 'a';
            if(arr[p] == 1) return true;
        }
        return false;
    }	
	
	
	public static void main(String[] args) {
		String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println("Words: ");
		for(int i=0; i < words.length; i++){
			System.out.print(words[i] + " ");
		}
        System.out.println();
		int res = maxProduct(words);
        System.out.println("Maximum products: " + res);
		return;
	}	
}
