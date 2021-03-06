class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //if(text1.length() > text2.length())
        // if(text1.length()==0 || text2.length()==0)
        //     return 0;
        return longestsubseq(text1, text2,text1.length(),text2.length());
       // return longestsubseq(text2, text1,text2.length()-1,text1.length()-1);
    }
    
    private int longestsubseq(String text1 ,String text2, int n ,int m)
    {
        if(n<0 || m<0)
            return 0;
        
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
        int i =n,j=m;
        String g ="";
        while(i>0 && j>0)
        {
            if(text1.charAt(i-1) == text2.charAt(j-1))
            {
                g = text1.charAt(i-1)+g;
                i--;
                j--;
            }
            else
            {
                if(dp[i][j-1] > dp[i-1][j])
                    j--;
                else
                    i--;
            }
        }
        System.out.println(g);
        return dp[n][m];
    }
}