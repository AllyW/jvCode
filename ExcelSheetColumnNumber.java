/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

import java.io.*;
import java.util.*;

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		if(s.length() == 0) return 0;
		int result = 0;
		for(int i = 0; i < s.length(); i++){
			result = result*26 + (s.charAt(i) - 'A' + 1);	
		}
		return result;
	}
	
	public static void main(String[] args) {
		String t = "ABACD";
		System.out.println("string: " + t);
		int r = titleToNumber(t);
		System.out.println("encode number: " + r);
		return;
	}	
}
