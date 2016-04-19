/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
*/

import java.io.*;
import java.util.*;

public class ClimbingStairs {
	public static int climbStairs(int n) {
        if(n <= 3) return n;
        int prepre = 2; 
        int pre = 3;
        int cur = 0;
        for(int i = 4; i <= n; i++){
            cur = prepre + pre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }	

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int res = climbStairs(n);
		System.out.println(res + " distinct ways to climp to the top");
		return;
	}	
}
