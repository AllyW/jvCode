/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:

"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

Note: Do not use the eval built-in library function. 
*/
import java.util.*;

public class BasicCalculator {
	public static int calculate_wrong(String s) { // fail, only can deal with plus, but if only plua, "(", ")" make no sense.
        if(s.length() <= 0) return 0;
        int L =s.length();
        int num = 0;
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i = 0; i< L; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
				//System.out.println( i + ": " + num);
            } else if(s.charAt(i) == '('){
                operator.push('(');
            }else if(s.charAt(i) == ' '){
                continue;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
				//System.out.println(i + ":" + s.charAt(i));
                operator.push(s.charAt(i));
                operands.push(num);
                num = 0;
            }
			if(s.charAt(i) == ')' || i == L - 1){
                while(!operator.isEmpty() && operator.peek() != '('){
                    int num2 = operands.pop();
                    char sign = operator.pop();
					System.out.println("num : " + num);
					System.out.println("num2 : " + num2);
					System.out.println("sign : " + sign);
                    if(sign=='+'){
                        num = num+num2;
                    }else if(sign == '-'){
                        num = num2 - num;
                    }
                }
                if(!operator.isEmpty() && operator.peek() == '(') operator.pop();
				System.out.println("cal result : " + num);
            }
        }
		if(operands.isEmpty()){
            return num;
        }else{
            while(!operands.isEmpty()){
            int num2 = operands.pop();
            char sign = operator.pop();
            if(sign=='+'){
                num = num+num2;
            }else if(sign == '-'){
                num = num2 - num;
            }
            }
            return num;
        }
      }
	
//https://leetcode.com/discuss/39553/iterative-java-solution-with-stack	
	public static int calculate(String s) {
        if(s.length() <= 0) return 0;
        int L =s.length();
        int num = 0;
        int neg = 1;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< L; i++){
			System.out.println(i + " : " + num);
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            }else if(s.charAt(i) == ' '){
                continue;
            }else if(s.charAt(i) == '+'){
                result += neg*num;
                neg = 1;
                num = 0;
            }else if(s.charAt(i) == '-'){
                result += neg*num;
                neg = -1;
                num = 0;
            }else if(s.charAt(i) == '('){
                st.push(result);
                st.push(neg);
                result = 0;
                neg = 1;
            }else if(s.charAt(i) == ')'){
                result += neg*num;
                result *= st.pop();
                result += st.pop();
                neg = 1;
                num = 0;
            } 
        }
		if(num != 0) result += neg * num;
		return result;
        
    }

	public static void main(String[] args) {
		//String s = "(1 +2 + (3) + 1)";
		String  s = "1 - (2-3 + 5)";
		//String s = "5   ";
		int res = calculate(s);
		System.out.println("String: " + s);
		System.out.println("Resulte: " + res);
		return;
	}	
}
