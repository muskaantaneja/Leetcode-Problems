class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        
        for(int current=0 ; current<nums.length ; current++){
        
            int key = nums[current];
            if(map.containsKey(key))
            {
                if(key + key == target)
                {
                    ans[0] = map.get(key);
                    ans[1] = current;
                    return ans;
                }
            }
            
            map.put(key , current);
        }
        for(int current : map.keySet())
        {
            if(map.containsKey(target - current)){
                ans[0] = map.get(current);
                ans[1] = map.get(target - current);
                return ans;
            }
        }
        return ans;
        
    }
}