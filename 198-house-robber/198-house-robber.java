class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length ;
        int memo[] = new int[n + 1];
        
        memo[n] = 0;
        memo[n-1] = nums[n-1];
        
        
        for(int i = n-2 ; i >= 0 ; i-- )
        {
            int consider = nums[i] + memo[i+2];
            int notconsider = memo[i+1];
            
            memo[i] = Math.max(consider , notconsider);
        }
        
        
        return memo[0];
    }
}