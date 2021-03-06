/*
 Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples:

"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

*/

import java.util.*;

public class ExpressionAddOperators {
    private static List<String> res = new ArrayList<String>();
	
	public static List<String> addOperators(String num, int target) {
        if(num.length()<= 0) return res;
        dfs(num, target, "", 0, 0, 0);
        return res;
    }
    
    public static void dfs(String num, int target, String path, int pos, long cal, long pre){
        if(pos == num.length() && cal == target){
            res.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i > pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i+1));
            if(pos == 0){
                dfs(num, target, path + cur+"", i+1, cur, cur);
            }else{
                dfs(num, target, path + "+" + cur, i+1, cal + cur, cur);
                dfs(num, target, path + "-" + cur, i+1, cal - cur, -cur);
                dfs(num, target, path + "*" + cur, i+1, cal - pre + pre*cur, pre*cur);
            }
        }
        return;
    }	
	
	public static void main(String[] args) {
		String input = "12323";
		int target = 20;
		List<String> res = addOperators(input, target);
        System.out.println("Results for " + target + " and " + input);
		for(int i=0; i < res.size(); i++){
			System.out.println(res.get(i) + " ");
		}
		return;
	}	
}
