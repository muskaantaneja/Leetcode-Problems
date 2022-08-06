class Solution {
    public boolean canJump(int[] nums) {
        
        int maxjump = 0;
        
        for(int current = 0 ; current < nums.length ; current++)
        {
            if(current > maxjump)
                return false;
            
            maxjump = Math.max(maxjump , current + nums[current]);
        }
        
        return true;
    }
}