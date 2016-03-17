/*
 Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z. 
*/

// note: any class is a set of variables and functions.
// search here is search for a string that starts from the root and must end with the root's endpoint
import java.io.*;
import java.util.*;
public class AddandSearchWord {
	public static class WordDictionary {
		public class WordTrie{
	        boolean isEnd;
		    WordTrie[] next;
			public WordTrie(){
	            isEnd = false;
		        next = new WordTrie[26];
	        }
	        
	    }
    
	    public WordTrie root;
		private WordTrie p;
	    public WordDictionary(){
		    root = new WordTrie();
	    }

		// Adds a word into the data structure.
	    public void addWord(String word) {
		    if(word.length() <= 0) return;
			p = root;
	        for(int i = 0; i < word.length(); i++){
		        if(p.next[word.charAt(i) - 'a'] == null){
			        p.next[word.charAt(i) - 'a'] = new WordTrie();
				}
	            p = p.next[word.charAt(i) - 'a'];
		    }
			p.isEnd = true;
	    }

		// Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if(word.length() <= 0) return true;
	        p = root;
		    if(searchWord(word, p)) return true;
			return false;
	    }
		
	    public boolean searchWord(String word, WordTrie start){
		    if(word.length() <= 0 && start.isEnd){
			    return true;
	        }else if(word.length() <= 0 && !start.isEnd){
		        return false;
	        }
		    if(start == null) return false;
			for(int i = 0; i < word.length(); i++){
	            if(word.charAt(i) == '.'){
		            for(int j = 0; j < 26; j++){
			            if(start.next[j] != null && searchWord(word.substring(i+1), start.next[j]) ){
				            return true;
					    }
	                }
		            return false;
			    }else if(start.next[word.charAt(i) - 'a'] == null){
					return false;
				}else{
	                start = start.next[word.charAt(i) - 'a'];
		        }
			}
	        return start.isEnd;
		}
	}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
//
	public static void main(String[] args) { 
		WordDictionary wordDictionary = new WordDictionary();
		String ins = "something";
		String ser = "some..ing";
		wordDictionary.addWord(ins);
		boolean canSearch = wordDictionary.search(ser);
		System.out.println("Before: " + ins);
		System.out.println("Is " + ser + " in: " + canSearch);
		return;
	}	
}
