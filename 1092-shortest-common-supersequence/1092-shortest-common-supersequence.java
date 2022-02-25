class Solution {
    public String shortestCommonSupersequence(String X, String Y) {
    return longestsubseq(X, Y,X.length(),Y.length());
    }
    public  String longestsubseq(String text1 ,String text2, int n ,int m)
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
                {
                    g = text2.charAt(j-1)+g;
                    j--;
                }
                else
                {
                    g = text1.charAt(i-1)+g;
                    i--;
                }
            }
        }
        System.out.println(g);
        if(g.length()==0)
            return new String(text1+text2);
        
        while(i >0)
        {
            g = text1.charAt(i-1) + g;
            i--;
        }
        while(j >0)
        {
            g = text2.charAt(j-1) + g;
            j--;
        }
        
        return g ;
        
    }
}