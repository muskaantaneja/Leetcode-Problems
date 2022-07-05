class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return targetsum(nums , 0 , target , new HashMap<>());
    }
    public int targetsum(int[] nums , int current , int target , HashMap<String,Integer> map){
        
        if( current >= nums.length && target == 0)
            return 1;
        if( current >= nums.length && target != 0)
            return 0;
        
        String key = current +"_" + target;
        if(map.containsKey(key))
            return map.get(key);
        
        int pos = targetsum( nums , current+1 , target + nums[current] , map);
        int neg = targetsum( nums , current+1 , target - nums[current] , map);
        
        map.put(key , pos + neg);
        
        return map.get(key);
    }
}