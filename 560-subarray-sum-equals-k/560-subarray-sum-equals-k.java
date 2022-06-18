class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int ans = 0;
        int prefixsum = 0;
        
        map.put(0 , 1);
        for(int i : nums)
        {
            prefixsum+= i;
            if(map.containsKey(prefixsum-k))
            {
                ans += map.get(prefixsum - k);
            }
            map.put( prefixsum , map.getOrDefault( prefixsum , 0) + 1);
            
        }
        return ans;
    }
}