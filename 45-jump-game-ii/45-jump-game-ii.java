class Solution {
    public int jump(int[] nums) {
     return jumpgame( nums , 0 , new HashMap<>());
    }
    
    public int jumpgame(int[] nums , int current , HashMap<Integer,Integer> memo){
        
        if(current >= nums.length-1)
            return 0;
        
        if(nums[current] == 0)
            return 100000;
        
        if(memo.containsKey(current))
            return memo.get(current);
        
        int ans = 1000000;
        for(int jumps = 1 ; jumps <= nums[current] ; jumps++){
            
            ans = Math.min(ans , 1 +  jumpgame(nums , current + jumps , memo)); 
            
        }
        
        memo.put(current , ans);
        return ans;
    }
}