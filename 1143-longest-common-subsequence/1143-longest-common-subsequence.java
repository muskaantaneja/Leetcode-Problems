class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //if(text1.length() > text2.length())
        if(text1.length()==0 || text2.length()==0)
            return 0;
        return longestsubseq(text1, text2,text1.length()-1,text2.length()-1,new HashMap<>());
       // return longestsubseq(text2, text1,text2.length()-1,text1.length()-1);
    }
    
    private int longestsubseq(String text1 ,String text2, int n ,int m,HashMap<String,Integer> memo)
    {
        if(n<0 || m<0)
            return 0;
        
        String key=n+"_"+m;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int h =0;
        
        if(text1.charAt(n) == text2.charAt(m))
        {
            h=1+longestsubseq(text1, text2,n-1,m-1,memo);
            memo.put(key,h);
            return h;
        }
        
       // if(text1.charAt(n) != text2.charAt(m))
        h = Math.max(longestsubseq(text1, text2,n-1,m,memo),longestsubseq(text1, text2,n,m-1,memo));
        memo.put(key,h);
        return h;
    }
}