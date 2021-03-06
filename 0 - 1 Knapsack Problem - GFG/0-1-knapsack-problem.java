// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
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
                    consider = val[current] + dp[w-wt[current]][current+1];
                }
                
                notconsider =  dp[w][current+1];
                
                dp[w][current] = Math.max(consider,notconsider);
            }
        }
        
        
        return dp[W][0];
    }
}


