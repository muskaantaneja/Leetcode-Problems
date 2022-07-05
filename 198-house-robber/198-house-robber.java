class Solution {
    public int rob(int[] nums) {
        
        return houserobber(nums , 0 , nums.length ,new HashMap<>());
    }
    public int houserobber(int[] nums , int current , int target , HashMap<Integer , Integer> memo) 
    {
        if(current >= target)
            return 0;
        
        if(memo.containsKey(current))
            return memo.get(current);
        
        int consider = nums[current] + houserobber(nums , current+2 ,target , memo );
        int notconsider = houserobber(nums , current+1 ,target , memo );
        
        memo.put( current , Math.max(consider , notconsider));
        
        return memo.get(current);
    }
}