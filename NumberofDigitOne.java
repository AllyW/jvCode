/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

    Beware of overflow.

*/

import java.io.*;
import java.util.*;

public class NumberofDigitOne {
	public static int countDigitOne(int n) {
        if(n <=0 ) return 0;
        if(n < 10) return 1;
        List<Integer> digit = new ArrayList<Integer>();
		int k = n;
        while(k >= 10){
            int bit = k%10;
            digit.add(bit);
            k = k/10;
        }
        digit.add(k);
        int counts = 0;
        int mod = 1;
        for(int i = 0; i < digit.size(); i++){
            int bit = digit.get(i);
            int front = n/(mod*10);
            int after = n%mod;
			System.out.print("bit: " + bit + " front:" + front + " after:" + after);
			System.out.println();
            if(bit==0){
                counts += front * mod;
            }else if(bit==1){
                counts += front*mod + after + 1;
            }else if(bit>1){
                counts += (front+1) * mod;
            }
            mod *=10;
        }
        return counts;
    }	

	public static int countDigitOneOverFlow(int n) {
        if(n <=0 ) return 0;
        if(n < 10) return 1;
        List<Integer> digit = new ArrayList<Integer>();
		int k = n;
        while(k >= 10){
            int bit = k%10;
            digit.add(bit);
            k = k/10;
        }
        digit.add(k);
        long counts = 0;
        long mod = 1;
        for(int i = 0; i < digit.size(); i++){
            int bit = digit.get(i);
            long front = n/(mod*10);
            long after = n%mod;
            if(bit==0){
                counts += front * mod;
            }else if(bit==1){
                counts += front*mod + after + 1;
            }else if(bit>1){
                counts += (front+1) * mod;
            }
            mod *=10;
        }
        return (int)counts;
    }	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int res = countDigitOne(n);
		System.out.println("number of digit one: " + res);
		return;
	}	
}
