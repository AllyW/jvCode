/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
*/
import java.util.*;

public class DecodeWays {
	public static int numDecodings(String s) { // incorrect, like 100
		if(s.length() <= 0) return 0;
		char[] str = s.toCharArray();
		if(str.length == 1 && str[0] == '0') return 0;
		int pre = str[0] != '0' ? 1 : 0;
		int prepre = 1;
		int cur = 0;
		for(int i = 1; i < s.length(); i++){
			if(str[i] - '0' == 0){
				cur = pre;
			}else if((str[i-1] - '0' == 1) || (str[i-1] - '0' == 2) && (str[i] - '0' <= 6)){
				cur = prepre + pre;
			}else{
				cur = pre;
			}
			prepre = pre;
			pre = cur;
		}
		return pre;
	}
	
	//https://leetcode.com/discuss/83547/java-clean-dp-solution-with-explanation
	public static int numDecodings2(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		for(int i = 2; i <= n; i++) {
			int first = Integer.valueOf(s.substring(i-1, i));
			int second = Integer.valueOf(s.substring(i-2, i));
			if(first >= 1 && first <= 9) {
				dp[i] += dp[i-1];  
			}
			if(second >= 10 && second <= 26) {
				dp[i] += dp[i-2];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		String s = "100";
		int res = numDecodings(s);
		int res2 = numDecodings2(s);
		System.out.println("String: " + s);
		System.out.println("Decoded ways: " + res);
		System.out.println("Decoded ways: " + res2);
		return;
	}	
}
