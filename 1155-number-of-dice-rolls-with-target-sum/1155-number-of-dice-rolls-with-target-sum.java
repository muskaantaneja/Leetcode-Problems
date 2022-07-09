class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        return noOfways( n , k , 0 , target, new HashMap<>());
    }
    public int noOfways(int n , int k , int current , int target , HashMap<String,Integer> memo){
        
        if(target < 0 || current > n)
            return 0 ;
        
        if(target == 0 && current==n)
            return 1;
        
        String key = current + "_" + target;
        if(memo.containsKey(key))
            return memo.get(key);
        
        
        int ans = 0;
        for(int i = 1 ; i <= k ; i++)
            ans = (ans % 1000000007 + noOfways(n , k , current+1 , target-i , memo) % 1000000007) % 1000000007;
        
        memo.put(key , ans);
        return ans;
    }
}