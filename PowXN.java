/*
Implement pow(x, n). 
*/

import java.io.*;
import java.util.*;

public class PowXN {
	public static double myPow(double x, int n) {
        double res=1;
        while(n!=0)
        {
            if(n%2==0)
            {

                x=x*x;
                n/=2;
            }
            else
            {
                if(n>0)
                {
                    res*=x;
                    n--;
                }
                else
                {
                    res/=x;
                    n++;
                }
            }
        }
        return res;
        
    }	

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter x: ");
		double x = reader.nextDouble();
		System.out.println("Enter exp n: ");
		int n = reader.nextInt();
		System.out.println("Result: " + myPow(x,n));
		return;
	}	
}
