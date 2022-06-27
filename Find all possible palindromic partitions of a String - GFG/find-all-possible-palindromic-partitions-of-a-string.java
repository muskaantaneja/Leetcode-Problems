// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>() ;
        psubstrings( 0 , 1, s , ans , list);
        
        return ans;
    }
    
    static void psubstrings( int start , int end , String s,ArrayList<ArrayList<String>> ans,
    ArrayList<String> list){
        
        if( end == s.length())
        {
            if(isvalid(s.substring(start , end))){
               
                list.add(s.substring(start , end));
                ans.add( new ArrayList<>(list) );
                list.remove(list.size() - 1);
            }
            
            return;
        }
        
        if(isvalid(s.substring(start , end))){
            list.add(s.substring(start , end));
            psubstrings( end , end+1, s , ans , list);
            list.remove(list.size() - 1);
        }
        
         
         
         psubstrings( start , end+1, s , ans , list);
         
         
        
         return;
    }
    static boolean isvalid(String str){
        
        String h = "";
        for(int i = 0 ; i<str.length() ; i++)
        {
            h = str.charAt(i) + h; 
        }
        
        if(str.equals(h))
        return true;
        
        return false;
    }
}