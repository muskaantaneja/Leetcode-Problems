// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] A,int n,int M){
        long sum = 0;
        long ans = -1;
        
        for(int i : A){
            sum = sum + i;
        }
        
        long start = 0;
        long end = sum;
        
        while(start <= end){
            
            long mid = start + (end - start)/2;
            
            if(isPossible(A , mid , M)){
                
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
            
        }
        
        return ans;
    }
    
    public static boolean isPossible(int[] A , long maxsum , int M){
        int currentsum = 0;
        int sc = 1;
        for(int i =0 ; i<A.length ; i++){
            
            if(A[i] > maxsum)
            return false;
            
            currentsum += A[i] ;
            
            if(currentsum > maxsum){
                sc++;
                
                if(sc > M)
                return false;
                
                currentsum = A[i];
            }
        }
        return true;
    }
}
