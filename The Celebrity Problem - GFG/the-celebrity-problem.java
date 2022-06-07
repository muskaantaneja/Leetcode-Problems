// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int m[][], int n)
    {
    	// code here 
    	Stack<Integer> stack = new Stack<>();
    	for(int i = 0 ; i < n ; i++){
    	    stack.push(i);
    	}
    	
    	while(stack.size() > 1 )
    	{
    	    int a = stack.peek();
    	    stack.pop();
    	    
    	    int b = stack.peek();
    	    stack.pop();
    	    
    	    if(m[a][b] == 1){
    	        if(m[b][a] != 1)
    	        stack.push(b);
    	    }
    	    else if(m[b][a] == 1)
    	   stack.push(a);
    	}
    	
    	if(stack.size() == 0 )
    	return -1;
    	int a = stack.peek();
    	for(int i = 0 ; i<n ;i++)
    	{
    	    if(m[a][i] == 1)
    	    return -1;
    	}
    	for(int i = 0 ; i<n ;i++)
    	{
    	    if(i != a && m[i][a] == 0)
    	    return -1;
    	}
    	
    	return stack.peek();
    }
}