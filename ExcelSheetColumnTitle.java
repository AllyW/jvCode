/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

import java.io.*;
import java.util.*;

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 26){
            int t = (n-1) % 26;
            sb.insert(0,(char)(t + 'A'));
            n = (n-1) / 26;
        }
        sb.insert(0, (char)(n-1 + 'A'));
        return sb.toString();
    }

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: "); // test 704, 52
		int n = reader.nextInt();
		String r = convertToTitle(n);
		System.out.println("Column title: " + r);
		return;
	}	
}
