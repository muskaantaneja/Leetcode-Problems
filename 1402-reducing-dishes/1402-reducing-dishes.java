class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxsat(satisfaction, 0, 0 ,new HashMap<>());
    }
    private int maxsat(int[] nums, int current, int rem, HashMap<String,Integer> memo)
    {
        if(current == nums.length)
            return 0;
        
        String key = current + "_"+ rem;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int consider = nums[current]*(rem+1) + maxsat(nums, current+1, rem+1 ,memo);
        int notconsider = maxsat(nums, current+1, rem ,memo);
        
        memo.put(key,Math.max(consider,notconsider));
        
        return memo.get(key);
    }
}