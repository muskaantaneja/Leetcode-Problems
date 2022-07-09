// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int matrix[][])
    {
        // code here
        int ans = 0;
        int[][] memo = new int[n+1][n+1];
        
        for(int col = 0 ; col < n ; col++)
        ans = Math.max(ans , maxpathSum(matrix , 0 , col, n , memo));
        
        return ans;
    }
    static int maxpathSum(int grid[][] , int row , int col , int n , int[][] memo)
    {
        if(row >= n || col>= n || col<0 || row<0)
        return 0;
        
        if(row == n-1)
        return grid[row][col];
        
        if(memo[row][col] != 0)
        return memo[row][col];
        
        int down = grid[row][col] + maxpathSum(grid , row + 1 , col , n , memo);
        int down_left = grid[row][col] + maxpathSum(grid , row + 1 , col - 1, n , memo);
        int down_right = grid[row][col] + maxpathSum(grid , row + 1 , col + 1, n , memo);
        
        memo[row][col] = Math.max(down , Math.max(down_left , down_right));
        
        return memo[row][col];
    }
}