class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        
        for(int current=0 ; current<nums.length ; current++){
        
            int key = nums[current];
           
            if(map.containsKey(target - key)){
                ans[0] = current;
                ans[1] = map.get(target - key);
                return ans;
            }
            
            map.put(key , current);
        }
        
        return ans;
        
    }
}