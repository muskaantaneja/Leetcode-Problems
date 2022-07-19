class Solution {
    public int maxProfit(int[] prices) {
    int canbuy = 1;
        
        int dp[][] = new int[prices.length + 2][canbuy + 1];
        
        
        
        for(int i = prices.length-1 ; i>=0 ; i--){//current
            
            for(int j = 0; j <=1 ; j++){//canbuy
                
                
                    int buy = 0,sell = 0,nothing=0;
                     if(j == 1)
                     {
                        buy =  -prices[i] + dp[i + 1][0];
                     }
                     else if(i+2 <= prices.length+1) {
            
                         sell = prices[i] + dp[i + 2][1] ;
                      }
         
                    nothing = dp[i + 1][j];
                    dp[i][j] = Math.max(buy+sell , nothing);
                
            }
        }

        return dp[0][1];
    }
}