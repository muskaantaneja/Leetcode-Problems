// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        // code here
        HashSet<String> set = new HashSet<>();
        
        for(String i : dict){
            set.add(i);
        }
        List<String> ans = new ArrayList<>();
        wordbreak( 0 , 1, s , set ,"" , ans);
        
        return ans;
    }
    
    static void wordbreak( int start , int end , String s, HashSet<String>set ,
    String str , List<String> ans){
        
        if( end == s.length())
        {
            if(set.contains(s.substring(start , end) )){
                str = str + s.charAt(end - 1);
                ans.add(str);
            }
            
            return;
        }
        
        if(set.contains(s.substring(start , end))){
            wordbreak( end , end+1, s , set ,str +  s.charAt(end-1) + " ", ans);
        }
        
         wordbreak( start , end+1, s , set ,str+s.charAt(end-1) , ans);
         
         return;
    }
}