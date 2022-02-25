class Solution {
    public int longestPalindromeSubseq(String s) {
        String nstr="";
        char ch;
       
      for (int i=0; i<s.length(); i++)
      {
        ch= s.charAt(i); 
        nstr= ch+nstr; 
      }
        
       // String h = "";
        return longestsubseq(s ,nstr, s.length(),s.length());
    }
    public  int longestsubseq(String text1 ,String text2, int n ,int m)
    {
        
        int dp[][]= new int[n+1][m+1];
        
        for(int i =1;i<n+1;i++)
        {
            for(int j =1;j<m+1;j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                {
                   dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m] ;
        
    }
}