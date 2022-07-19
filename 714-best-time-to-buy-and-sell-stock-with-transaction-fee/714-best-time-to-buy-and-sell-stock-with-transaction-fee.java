class Solution {
    public int maxProfit(int[] prices, int fee) {
        int canbuy = 1;
        
        int dp[][] = new int[prices.length + 1][canbuy + 1];
        
        
        
        for(int i = prices.length-1 ; i>=0 ; i--){//current
            
            for(int j = 0; j <=1 ; j++){//canbuy
                
                
                    int buy = 0,sell = 0,nothing=0;
                     if(j == 1)
                     {
                        buy =  -prices[i] + dp[i + 1][0];
                     }
                     else {
            
                         sell = prices[i] + dp[i + 1][1] - fee;
                      }
         
                    nothing = dp[i + 1][j];
                    dp[i][j] = Math.max(buy+sell , nothing);
                
            }
        }

        return dp[0][1];
    }
}