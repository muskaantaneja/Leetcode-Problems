// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        
        int ans = -1,left = 0;
        
        for(int right = 0 ; right < s.length() ; right++ )
        {
            char key=s.charAt(right);
            
            map.put(key , map.getOrDefault(key , 0) + 1);
            
            while(map.size()>k && left<s.length()){
                  int count = map.get( s.charAt(left) );
                  
                  count--;
                  if(count == 0)
                  map.remove(s.charAt(left));
                  else
                  map.put(s.charAt(left) , count);
                  
                  left++;
            }
            
            int a = right - left + 1;
           // map.put(key , right);
            if(map.size() == k)
            ans = Math.max(ans , a);
           //  System.out.println( s + " "+ left);    
        }
        return ans;
    }
}