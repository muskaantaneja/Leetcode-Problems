class Solution {
    public int maxProfit(int k, int[] prices) {
       return buyandsell(prices , 0 , 1 , k , new HashMap<>());
    }
    public int buyandsell(int[] prices , int current , int canbuy ,int trans,HashMap<String , Integer>memo){
        
        if(trans == 0 && canbuy == 1 )
            return 0;
        
        if(current >= prices.length || trans<0)
            return 0;
        String key = current + "_" + canbuy + "_" + trans;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int buy = 0,sell = 0,nothing=0;
        
        if(canbuy == 1)
        {
             buy =  -prices[current] + buyandsell(prices , current + 1 , 0 , trans - 1,memo);
        }
        else if( canbuy == 0){
            
            sell = prices[current] + buyandsell(prices , current + 1 , 1 , trans , memo);
        }
         
        nothing = buyandsell(prices , current + 1 , canbuy , trans ,memo);
        
        memo.put(key , Math.max(buy + sell , nothing));
        return memo.get(key);
    }
}