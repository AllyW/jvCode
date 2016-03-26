/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.
Have you thought about this?

Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.

*/

import java.io.*;
import java.util.*;

public class ReverseInteger {
	public static int reverse(int x) {
        int sign = x >= 0 ? 1: -1;
        x = Math.abs(x);
        long res = 0;
        int d = 1;
        while( x > 0){
            int k = x % 10;
            res = res*10 + k;
            if( res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return sign == -1 ? (int)-res: (int)res; 
    }	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int res = reverse(n);
		System.out.println("Reverse number: " + res);
		return;
	}	
}
