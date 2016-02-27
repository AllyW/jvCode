/*
 You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API. 
*/

import java.util.*;

public class FirstBadVersion {
	public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int m = 0;
        while(l <= r){
            m = l + (r - l)/2;
            if(isBadVersion(m) == true){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        if(isBadVersion(r) == true){
            return r;
        }else if(isBadVersion(m) == true){
            return m;
        }else{
            return l;
        }
    }
//simple test, assume n == 3, bad version is 2
	public static boolean isBadVersion(int n) {
		if(n == 2) return true;
		return false;
    }

	
	public static void main(String[] args) {
		int  n = 3;
		System.out.println("the bad version is: " + firstBadVersion(n));
		return;
	}	
}
