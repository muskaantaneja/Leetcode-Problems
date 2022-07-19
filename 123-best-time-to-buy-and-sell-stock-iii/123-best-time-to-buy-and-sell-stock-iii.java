class Solution {
    public int maxProfit(int[] prices) {
       int canbuy = 1;
        int trans = 2;
        int dp[][][]= new int[prices.length + 1][canbuy + 1][trans + 1];
        
        
        
        for(int i = prices.length-1 ; i>=0 ; i--){//current
            
            for(int j = 0; j <=canbuy ; j++){//canbuy
                
                for(int k = 1 ; k  <= trans ; k++){//trans
                    int buy = 0,sell = 0,nothing=0;
                     if(j == 1)
                     {
                        buy =  -prices[i] + dp[i + 1][0][k];
                     }
                     else {
            
                         sell = prices[i] + dp[i + 1][1][k-1];
                      }
         
                    nothing = dp[i + 1][j][k];
                    dp[i][j][k] = Math.max(buy+sell , nothing);
                }
            }
        }

        return dp[0][canbuy][trans];
}
}