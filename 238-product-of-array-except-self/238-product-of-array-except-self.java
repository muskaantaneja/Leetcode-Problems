class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefixpro[] = new int[nums.length];
        int suffixpro[] = new int[nums.length];
        
        int pro = 1;
        for(int i = 0 ; i < nums.length ; i++)
        {
            
            prefixpro[i] = pro;
            pro *= nums[i];
        }
        pro = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--)
        {
            suffixpro[i] = pro;
            pro *= nums[i];
        }
        
        int ans[] =  new int[nums.length];
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            ans[i] = prefixpro[i] * suffixpro[i];
        }
        return ans;
    }
}