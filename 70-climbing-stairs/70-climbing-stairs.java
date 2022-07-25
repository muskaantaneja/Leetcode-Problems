class Solution {
    public int climbStairs(int n) {
        
        return totalWays( n, new int[n+2]);
    }
    
    public int totalWays(int n , int[] memo){
        
        memo[n+1] = 0;
        memo[n] = 1;
        
        for(int i = n-1 ; i >= 0 ; i--)
        {
            int onestep = memo[i+1];
            int twostep = memo[i+2];
        
            int ans = onestep + twostep;
            memo [i] = ans;
        }
        
        return memo[0];
    }
}