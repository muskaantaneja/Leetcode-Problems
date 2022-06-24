class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getsubsets(nums , 0 , ans , list);
        
        return ans;
    }
    public void getsubsets(int[] nums ,int n ,List<List<Integer>> ans ,List<Integer> list)
    {
        
        if(n >= nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[n]);
        getsubsets(nums , n+1 , ans , list);
        
        list.remove(list.size() - 1);
        getsubsets(nums , n+1 , ans , list);
        
        return ;
    }
}