class Solution {
    public int change(int amount, int[] coins) {
        int ans = countcoins(coins , 0 , amount , new HashMap<>());
        return ans;
    }
    
    public int countcoins(int[] coins , int current , int target , HashMap<String ,Integer> memo){
        
        if(target == 0)
            return 1;
        if(current >= coins.length)
            return 0;
        
        String key = current + "_" + target;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int consider = 0;
        if(target >= coins[current])
        consider = countcoins( coins , current , target - coins[current] , memo);
        
        int notconsider =  countcoins( coins , current + 1, target  , memo);
        memo.put(key , consider + notconsider);
        
        return memo.get(key);
    }
}