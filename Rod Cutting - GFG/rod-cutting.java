// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int N) {
        //code here
       int[][] dp = new int[N+1][N+1];
       
       for(int current = N-1 ; current>=0 ; current--){
           for(int n = 1 ; n <= N ; n++){
                int consider=0;
                if(n >= current+1)
                consider = price[current]+dp[current][n-current-1];
                int notconsider=  dp[current+1][n];
                dp[current][n] = Math.max(consider,notconsider);
           }
       }
        
        return dp[0][N];
    }
    // private int rodcutting(int price[], int current, int n,HashMap<String,Integer>memo)
    // {
    //     if(n==0)
    //     return 0;
    //     if(current>=price.length)
    //     return 0;
    //     String key=current+"_"+n;
    //     if(memo.containsKey(key))
    //     return memo.get(key);
    //     int consider=0;
    //     if(n-(current+1)>=0)
    //     consider = price[current]+rodcutting(price,current,n-current-1,memo);
    //     int notconsider=  rodcutting(price,current+1,n,memo);
    //     memo.put(key,Math.max(consider,notconsider));
    //     return memo.get(key);
    // }
}