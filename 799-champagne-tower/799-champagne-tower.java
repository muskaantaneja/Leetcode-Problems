class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_row+1];
        
        dp[0][0] = poured;
        for(int i = 0; i<query_row; i++)
        {
            for(int j = 0 ;j<=i;j++)
            {
                double val = dp[i][j] - 1;
                val= val/2.00;
                if(val > 0)
                {
                    dp[i+1][j] += val;
                    dp[i+1][j+1] += val;
                }
            }
        }
        
        return Math.min(1,dp[query_row][query_glass]);
    }
}