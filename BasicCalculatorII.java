/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:

"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5

Note: Do not use the eval built-in library function. 
*/
import java.util.*;

public class BasicCalculatorII {
	public static int calculate(String s) {
        if(s.length() == 1) return s.charAt(0) - '0';
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+'; // store the last sign before current operands
        for(int i = 0; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            }
            
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1){ // two situation for cal, one: reach the next operator,
 //two: reach the end.
                if(sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    int num0 = st.pop();
                    st.push(num0 * num);
                }else if(sign == '/'){
                    int num0 = st.pop();
                    st.push(num0/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
            
        }
        int re = 0;
        for(int i:st){
            re += i;
        }
        return re;    
    }
	
	public static void main(String[] args) {
		String s = "1 + 2*3 + 1";
		int res = calculate(s);
		System.out.println("String: " + s);
		System.out.println("Resulte: " + res);
		return;
	}	
}
