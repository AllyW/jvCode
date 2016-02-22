/*
 There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

*/

import java.io.*;
import java.util.*;

public class BulbSwitcher {
	public static int bulbSwitch(int n) {
        if(n <= 1) return n;
        boolean[] bp = new boolean[n];
		System.out.println(bp[0]);
        for(int i = 0; i < n; i++){
            for(int j = i; j< n; j+=i+1){
                bp[j] = !bp[j];
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(bp[i] == true) res++;
        }
        return res;
    }

	//https://leetcode.com/discuss/77125/crystal-clear-explanation-one-line-c-code
	public static int bulbSwitch2(int n) {
        if(n <= 1) return n;
        int res = (int)Math.sqrt(n); // find the number of square numbers under n.
        return res;
    }
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int res = bulbSwitch(n);
		int res2 = bulbSwitch2(n);
		System.out.println("Remaining bulb from method 1: " + res);
		System.out.println("Remaining bulb from method 2: " + res2);
		return;
	}	
}
