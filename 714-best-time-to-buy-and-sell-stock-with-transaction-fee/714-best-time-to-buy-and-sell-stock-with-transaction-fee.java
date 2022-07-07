class Solution {
    public int maxProfit(int[] prices, int fee) {
         return Math.max(0 ,buyandsell(prices , 0 , 1 , fee , new HashMap<>()));
    }
    public int buyandsell(int[] prices , int current , int canbuy ,int fee,HashMap<String , Integer>memo)     {
        
        if(current >= prices.length)
            return 0;
        String key = current + "_" + canbuy;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int buy = 0,sell = 0,nothing=0;
        
        if(canbuy == 1)
        {
             buy =  -prices[current] + buyandsell(prices , current + 1 , 0 , fee,memo) - fee;
        }
        else if( canbuy == 0 ){
            
            sell = prices[current] + buyandsell(prices , current + 1 , 1 , fee, memo);
        }
         
        nothing = buyandsell(prices , current + 1 , canbuy , fee ,memo);
        
        memo.put(key , Math.max(buy + sell , nothing));
        return memo.get(key);
    }
}