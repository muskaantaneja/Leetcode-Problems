class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        HashSet<List<Integer>> memo = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length - 1 ; i++){
 
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            twoSum( nums , i + 1 ,-nums[i] , list , memo);
            System.out.println(list);
        }
        
        for(List<Integer> arr : memo)
            ans.add(arr);
        
        return ans;
    }
    public void twoSum(int[] nums,int start, int target , List<Integer>list , HashSet<List<Integer>> memo) {
        HashSet<Integer> map = new HashSet<>();
        
        for(int current=start ; current<nums.length ; current++){
        
            int key = nums[current];
            if(map.contains(key))
            {
                if(key + key == target)
                {
                    
                   list.add(key);
                    list.add(key);
                    memo.add(new ArrayList(list));
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                }
            }
            
            map.add(key);
        }
        HashSet<Integer> set = new HashSet<>(map);
        for(int current : map)
        {
            set.remove(current);
            if(set.contains(target - current)){
                list.add(target-current);
                list.add(current);
                
                memo.add(new ArrayList(list));
                list.remove(list.size()-1);
                    list.remove(list.size()-1);
            }
           // set.add(current);
        }
        return ;
        
    }
}