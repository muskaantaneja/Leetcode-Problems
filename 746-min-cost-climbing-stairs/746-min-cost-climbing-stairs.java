class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
       // int memo[] = new int[n+1];
        
        int prev2 = cost[0];
        int prev = Math.min(prev2 , 0) + cost[1];
        int ans = 0;
        for(int i = 2 ; i<=n ; i++){
            
            ans =  Math.min(prev , prev2);
            if( i < n)
                ans += cost[i];
            
            prev2 = prev;
            prev = ans;
        }
        return ans;
    }
}