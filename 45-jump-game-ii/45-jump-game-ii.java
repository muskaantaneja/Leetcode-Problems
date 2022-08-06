class Solution {
    public int jump(int[] nums) {
        
        if(nums.length == 1)
            return 0;
        
        int maxjump = 0;
        int steps = 0;
        int prevjump = 0;
        for(int current = 0 ; current < nums.length ; current++)
        {
            if(prevjump < current)
           {
               steps++;
               prevjump = maxjump;
           }
            if(prevjump >= nums.length-1)
                return steps;
           
           maxjump = Math.max(maxjump, current+nums[current]); 
            
        }
        
        return 0;
    }
}