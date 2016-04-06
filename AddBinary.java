/*
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 
*/

import java.util.*;

public class AddBinary {
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int M = a.length();
        int N = b.length();
        int i = M-1;
        int j = N-1;
        int adds = 0;
        while(i >= 0 || j >= 0){
            int o1 = 0;
            int o2 = 0;
            if(i >= 0){
                o1 = a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                o2 = b.charAt(j) - '0';
                j--;
            }
            int sum = o1+o2+adds;
            sb.append(sum%2);
            adds = sum/2;
            
        }
        if(adds == 1){
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		String p = "10111";
		String s = "101";
        String res = addBinary(p, s);
        System.out.println("String 1: " + p);
        System.out.println("String 2: " + s);
        System.out.println("Result: " + res);
		return;
	}	
}
