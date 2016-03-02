/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output: [0, 2]

Example 2

Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Output: [-34, -14, -10, -10, 10]
*/

import java.util.*;

public class DifferentWaystoAddParentheses {
	public static List<Integer> diffWaysToCompute(String input) {
        if(input.length() <= 0) return new ArrayList<Integer>();
         List<Integer> res = new ArrayList<Integer>();
         for( int i = 0; i < input.length(); i++){
             if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                 List<Integer> left = diffWaysToCompute(input.substring(0, i));
                 List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
                 for( int leftn : left){
                     for(int rightn : right){
                         if(input.charAt(i) == '+'){
                             res.add(leftn + rightn);
                         }else if(input.charAt(i) == '-'){
                             res.add(leftn - rightn);
                         }else if(input.charAt(i) == '*'){
                             res.add(leftn * rightn);
                         }
                     }
                 }
             }
         }
         if(res.isEmpty()) {
             int n = Integer.parseInt(input);
             res.add(n);
         }
         return res;
             
    }	
	
	public static void main(String[] args) {
        System.out.println("Input expression with only -, + or *: ");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		List<Integer> res = diffWaysToCompute(input); // input cannot contain space
        System.out.println("possible results: ");
		for(int i=0; i < res.size(); i++){
			System.out.print(res.get(i) + ", ");
		}
		return;
	}	
}
