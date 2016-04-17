/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4. 
*/

import java.util.*;

public class BitwiseANDofNumbersRange {
	public static int rangeBitwiseAnd(int m, int n) {
        if(m > n) return 0;
        int r = Integer.MAX_VALUE;
        while((m&r)!= (n&r)) r <<= 1;
        return n&r;
    }

	public static void main(String[] args) {
		int res = rangeBitwiseAnd(4, 7);
        System.out.println("And for 4 and 7 is: " + res);
		return;
	}	
}
