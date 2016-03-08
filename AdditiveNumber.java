/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.

1 + 99 = 100, 99 + 100 = 199

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers? 
*/
import java.util.*;

public class AdditiveNumber {
	public static boolean isAdditiveNumber(String num) {
        if(num.length() <= 2) return false;
        int L = num.length();
        int index0 = 0;
        int index1;
        int index2;
        int upper = L;
        if(num.charAt(0) == '0') upper = 1;   // --
        for(index1 = 1; index1 <= upper; index1++){
            for(index2 = index1 + 1; index2 < L; index2++){
                if(index2-index1 >= 2 && num.charAt(index1) == '0') continue;  //--
                long num1 =  Long.parseLong(num.substring(0, index1));
                long num2 = Long.parseLong(num.substring(index1, index2));
                if(canContinue(num.substring(index2), num1, num2)) return true;
            }
        }
        return false;
    }
    
    public static boolean canContinue(String substr, long num1, long num2){
        if(substr.equals("")) return true;
        long sum = num1 + num2;
        String s = ((Long)sum).toString();
        if(!substr.startsWith(s)) return false;
        return canContinue(substr.substring(s.length()), num2, sum);
    }

	public static void main(String[] args) {
		String s = "112358";
		boolean res = isAdditiveNumber(s);
		System.out.println("String: " + s);
		System.out.println("Is additive: " + res);
		s = "0112358";
		res = isAdditiveNumber(s);
		System.out.println("String: " + s);
		System.out.println("Is additive: " + res);
		s = "0235813";
		res = isAdditiveNumber(s);
		System.out.println("String: " + s);
		System.out.println("Is additive: " + res);
		return;
	}	
}
