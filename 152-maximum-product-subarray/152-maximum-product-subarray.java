class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min;
        min =  nums[0];
        
        int max ;
        max = nums[0];
        
        int ans = nums[0];
        
        for(int i = 1; i < n; i++){
            int prev1 = max;
            int prev2 = min;
            
            max = Math.max(nums[i], Math.max( prev1 * nums[i], prev2 * nums[i]));
            min = Math.min(nums[i], Math.min(prev1 * nums[i], prev2 * nums[i]));
            
            ans = Math.max(ans, max);
            
        }
        return ans;
    }
}