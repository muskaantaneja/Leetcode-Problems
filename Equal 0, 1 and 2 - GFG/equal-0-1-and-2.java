// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        long ans = 0;
        int zeros = 0;
        int ones =0 , twos=0;
        
        HashMap<String , Integer> memo = new HashMap<>();
        
        memo.put("0_0" , 1);
        for(int i = 0 ; i<str.length() ; i++)
        {
            char currentchar = str.charAt(i);
            
            if(currentchar == '0')
            zeros++;
            else if(currentchar == '1')
            ones++;
            else if(currentchar == '2')
            twos++;
            
            int a = ones - zeros;
            int b = twos - ones;
            
            String key = a + "_" + b;
            
            if(memo.containsKey(key)){
               // int length = i - memo.get(key);
               // ans += memo.get(key);
                memo.put(key , memo.get(key) +1);
            }
            else
            memo.put(key , 1);
        }
        
        for(String i : memo.keySet()){
            
            int n = memo.get(i);
            ans += ((n-1)*(n))/2;
        }
        return ans;
    }
} 