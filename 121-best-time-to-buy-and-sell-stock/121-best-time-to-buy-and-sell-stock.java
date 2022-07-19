class Solution {
    public int maxProfit(int[] prices) {
        return buyandsell(prices , 0 , 1 , 1 );
    }
    public int buyandsell(int[] prices , int current , int canbuy ,int trans){
        
        if(trans == 0 && canbuy == 1 )
            return 0;
        
        if(current >= prices.length || trans<0)
            return 0;
       
       int dp[][][]= new int[prices.length + 1][canbuy + 1][trans + 1];
        
        
        
        for(int i = prices.length-1 ; i>=0 ; i--){//current
            
            for(int j = 1; j >=0 ; j--){//canbuy
                
                for(int k = 1 ; k  < 2 ; k++){//trans
                    int buy = 0,sell = 0,nothing=0;
                     if(j == 1)
                     {
                        buy =  -prices[i] + dp[ i + 1][0][k];
                     }
                     else {
            
                         sell = prices[i] + dp[i + 1][1][k-1];
                      }
         
                    nothing = dp[i + 1][j][k];
                    dp[i][j][k] = Math.max(buy+sell , nothing);
                }
            }
        }
//      for(int i = 0 ; i<=prices.length ; i++){//current
            
//             for(int j = 0 ; j < 2 ; j++){//canbuy
                
//                 for(int k = 0 ; k<2 ; k++){//trans
//                     System.out.print(dp[i][j][k] + " ");
//                 }
//             }
//          System.out.println();
//         }
        return dp[0][1][1];
    }
    
//     public int buyandsell(int[] prices , int current , int canbuy ,int trans,HashMap<String , Integer>memo){
        
//         if(trans == 0 && canbuy == 1 )
//             return 0;
        
//         if(current >= prices.length)
//             return 0;
//         String key = current + "_" + canbuy + "_" + trans;
        
//         if(memo.containsKey(key))
//             return memo.get(key);
        
//         int buy = 0,sell = 0,nothing=0;
        
//         if(canbuy == 1)
//         {
//              buy =  -prices[current] + buyandsell(prices , current + 1 , 0 , trans - 1,memo);
//         }
//         else if( canbuy == 0 && trans == 0){
            
//             sell = prices[current] + buyandsell(prices , current + 1 , 1 , trans - 1, memo);
//         }
         
//         nothing = buyandsell(prices , current + 1 , canbuy , trans ,memo);
        
//         memo.put(key , Math.max(buy + sell , nothing));
//         return memo.get(key);
//     }
 }