// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <S.length() ; i++){
            char a = S.charAt(i);
            if(a != '+' && a != '-' && a != '/' && a != '*')
            {
                int r = a - '0';
                stack.push(r);
            }
            else
            {
                int b = stack.peek();
                stack.pop();
                int c = stack.peek();
                stack.pop();
                if(a == '*')
                stack.push(c*b);
                if(a == '-')
                stack.push(c - b);
                if(a == '+')
                stack.push(c+b);
                if(a == '/')
                stack.push(c/b);
            }
        }
        
        return stack.peek();
    }
}