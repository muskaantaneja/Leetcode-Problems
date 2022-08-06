class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        
        int buy = prices[0];
        int profit = 0;
        
        for(int current = 1 ; current < prices.length ; current++){
            
            if(prices[current] < buy)
                buy = prices[current];
            profit = Math.max(profit , prices[current] - buy);
        }
       // System.out.println(buy + " " + sell);
        return profit;
    }
}