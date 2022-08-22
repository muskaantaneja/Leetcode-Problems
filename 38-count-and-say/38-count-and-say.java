class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        if(n==2)
            return "11";
        return makeString(2 ,n , "11");
    }
    public String makeString(int current , int n , String ans)
    {
        if(current == n)
            return ans;
        
        int count = 1;
        int len = 1;

        String str = "";
        
        while(len < ans.length())
        {
            while(len < ans.length() && ans.charAt(len-1) == ans.charAt(len))
            {
                len++;
                count++;
            }
            str = str + count +"" + ans.charAt(len-1);
            count = 1;
            len++;
        }
        
        if(ans.length() > 1 && len == ans.length())
            str = str + count + "" + ans.charAt(ans.length()-1);
    
       return makeString(current + 1 , n , str);
        
    }
}