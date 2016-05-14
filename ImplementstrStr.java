/*
 Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
*/
import java.util.*;

public class ImplementstrStr {
	public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        if(needle.length() == 0) return 0;
        for(int i = 0; i <= haystack.length()-needle.length(); i++){
            boolean e = true;
            for(int j = 0; j < needle.length(); j++){
                if(needle.charAt(j) != haystack.charAt(i+j)) e = false;
            }
            if(e == true){
                return i;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		String s = "abcddwdw";
		String t = "cdd";
		int res = strStr(s, t);
		System.out.println("Source string: " + s);
		System.out.println("Taregt string: " + t);
		System.out.println("first occurrence position: " + res);
		return;
	}	
}
