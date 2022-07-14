// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        return knapsack(W , wt,val);
    }
    static int knapsack(int W , int wt[],int val[]){
        
        int n = wt.length;
        int dp[][] = new int[W+1][n+1];
        
        for(int[] arr : dp)
        Arrays.fill(arr , 0);
        
        for(int i = 0 ; i < W+1 ; i++){
            
            dp[i][n] = 0;
        }
        
        for(int current = n-1 ; current >= 0 ;  current--){
            
            for(int w = 1 ; w <= W ; w++){
                
                int consider=0,notconsider=0;
                if(w-wt[current]>=0)
                {
                    consider = val[current] + dp[w-wt[current]][current];
                }
                
                notconsider =  dp[w][current+1];
                
                dp[w][current] = Math.max(consider,notconsider);
            }
        }
        
        
        return dp[W][0];
    }
}