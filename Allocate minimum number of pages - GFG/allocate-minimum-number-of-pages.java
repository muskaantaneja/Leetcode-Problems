// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        long sum = 0;
        int ans = -1;
        
        for(int i : A){
            sum = sum + i;
        }
        
        int start = 0;
        int end = (int)sum;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
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
    
    public static boolean isPossible(int[] A , int maxsum , int M){
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
};