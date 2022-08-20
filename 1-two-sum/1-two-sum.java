class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        
        for(int current=0 ; current<nums.length ; current++){
            
            //System.out.println(ans[0] + "  " + ans[1]);
            int key = nums[current];
           // System.out.println(key);
            if(map.containsKey(key))
            {
                if(key + key == target)
                {
                    ans[0] = map.get(key);
                    ans[1] = current;
                     System.out.println(ans[0] + "  " + ans[1]);
                    return ans;
                }
            }
            
            map.put(key , current);
            System.out.println(map.get(key));
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