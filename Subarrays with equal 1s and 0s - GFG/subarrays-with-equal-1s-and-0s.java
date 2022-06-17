// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int prefixsum = 0;
        int ans = 0;
        int a = 0;
        map.put(a , 1);
        
        for(int i = 0 ; i<n ; i++){
            
            if(arr[i] == 1)
            prefixsum += arr[i];
            else
            prefixsum += -1;
            
            if(map.containsKey(prefixsum))
            {
                ans += map.get(prefixsum);
                map.put(prefixsum , map.get(prefixsum) + 1);
            }
            else
            map.put(prefixsum , 1);
            
        }
        
        
        return ans;
    }
}


