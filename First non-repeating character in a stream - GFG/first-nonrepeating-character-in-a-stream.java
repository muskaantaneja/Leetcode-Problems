// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        String s = "";
        
        for(int i =0 ; i<A.length() ; i++){
            
            int count = 0;
            char key = A.charAt(i);
            
            if(map.containsKey(key))
            count = map.get(key);
            
            count++;
            
            map.put(key,count);
            
            q.add(key);
            
            while(!q.isEmpty())
            {
                if(map.get(q.peek()) > 1)
                q.poll();
                
                else{
                    s = s + q.peek();
                    break;
                } 
                
            }
            
            if(q.isEmpty())
            s = s + '#';
        }
        return s;
    }
}