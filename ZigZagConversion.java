/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
*/
import java.util.*;
import java.io.*;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb =new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        int r = 0;
        int sig = 1;
        for(int i = 0; i < s.length(); i++){
            if(r==0){
                sig = 1;
            }else if(r == numRows-1){
                sig = -1;
            }
            sb[r].append(s.charAt(i));
            r += sig;
        }
        String res = "";
        for(int i = 0; i < numRows; i++){
			System.out.println("ZigZag String at " + i + ": " + sb[i].toString());
            res += sb[i].toString();
        }
        return res;
    }	
	
	public static void main(String[] args) {
		String s = "whereismystring";
		System.out.println("Source string: " + s);
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number for rows: ");
		int n = reader.nextInt();
		String res = convert(s, n);
		System.out.println("ZigZag String: " + res);
		return;
	}	
}
