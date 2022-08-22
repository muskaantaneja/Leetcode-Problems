class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        if(n==2)
            return "11";
        return makeString(3 ,n , "11");
    }
    public String makeString(int current , int n , String ans)
    {
        if(current-1 == n)
            return ans;
        
        int count = 0;
        int len = 1;
        count = 1;
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
        
        //System.out.println("ans " + str);
       return makeString(current + 1 , n , str);
        
    }
}