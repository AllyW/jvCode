/*
 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

*/
import java.util.*;
import java.io.*;

public class RepeatedDNASequences {
	public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 0) return new ArrayList<String>();
        Set<String> res = new HashSet<String>();
        Set<String> c = new HashSet<String>();
        for(int i = 0; i < s.length() - 9; i++){
            String temp = s.substring(i, i+10);
            if(!c.add(temp)) res.add(temp);
        }
        return new ArrayList<String>(res);
    }

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a DNA sequense (A, G, C, T): ");
		String s = reader.nextLine();
		List<String> res = findRepeatedDnaSequences(s);
		System.out.println("result: ");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
