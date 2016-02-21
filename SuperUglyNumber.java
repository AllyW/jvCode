/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000. 
*/

import java.io.*;
import java.util.*;

public class SuperUglyNumber {
	public static int nthSuperUglyNumbe(int n, int[] primes) {
        if(primes.length <= 0 || n < 0) return -1;
        if(n == 0) return 1;
        int[] res = new int[n];
        int L = primes.length;
        int[] index = new int[L];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            int nm = Integer.MAX_VALUE;
            for(int j = 0; j<L; j++){
                nm = Math.min(nm, res[index[j]]*primes[j]);
            }
            for(int j = 0; j<L; j++){
                if(nm == res[index[j]]*primes[j]){
                    index[j]++;
                }
            }
            res[i] = nm;
        }
        return res[n-1];
        
    }	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int[] primes = new int[]{2, 3, 5};
		for(int j = 0; j<primes.length; j++){
			System.out.print(primes[j] + " ");
        }
		System.out.println();

		int res =nthSuperUglyNumber(n, primes);
		System.out.println("The " + n + "th super ugly number is: " + res);
		return;
	}	
}
