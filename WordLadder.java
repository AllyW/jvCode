/*
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the word list

For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.

*/

import java.util.*;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;
        int res = 1;
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        q.offer(null);
        HashSet<String> hs = new HashSet<>();
        hs.add(beginWord);
        while(!q.isEmpty()){
            String a = q.poll();
            if(a != null){
                for(int i=0; i<a.length();i++){
                    char[] chars = a.toCharArray();
                    for(int j = 0; j < 26; j++){
                        chars[i] = (char)(j + 'a');
                        String word = new String(chars);
                        if(word.equals(endWord)) return res+1;
                        if(hs.contains(word)) continue;
                        if(wordList.contains(word)){
                            q.offer(word);
                            hs.add(word);
                        }
                    }
                }
            }else{
                res++;
                if(q.isEmpty()) break;
                q.offer(null);
            }
        }
        return 0;
    }  

   	public static void main(String[] args) {
		String[] wordList = new String[]{"hot","dot","dog","lot","log"};
		String beginWord = "hit";
		String endWord = "cog";
		HashSet<String> hl = new HashSet<>();
		for(int i=0; i < wordList.length; i++){
			hl.add(wordList[i]);
			System.out.print(wordList[i] + " ");
		}
		System.out.println();		
		int res = ladderLength(beginWord, endWord, hl);
        System.out.println("Begin word: " + beginWord);
        System.out.println("End word: " + endWord);
        System.out.println("Distance: " + res);
		return;
	}	
}
