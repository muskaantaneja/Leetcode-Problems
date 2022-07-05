class Solution {
    public int climbStairs(int n) {
        
        return totalWays( 0, n , new HashMap<>());
    }
    
    public int totalWays(int current , int n , HashMap<Integer , Integer> map){
        
        if(current == n)
            return 1;
        
        if(current > n)
            return 0;
        
        if(map.containsKey(current))
            return map.get(current);
        
        int onestep = totalWays(current + 1 , n , map);
        int twostep = totalWays(current + 2 , n , map);
        
        int ans = onestep + twostep;
        
        map.put(current , ans);
        return ans;
    }
}