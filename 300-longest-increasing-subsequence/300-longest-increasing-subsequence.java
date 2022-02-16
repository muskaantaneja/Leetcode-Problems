class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        
        Arrays.fill(memo,1);
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i ;j++)
            {
                if(nums[i]>nums[j])
                    memo[i] = Math.max(memo[j]+1,memo[i]);
            }
        }
        int ans=0;
        for(int i=0; i<n; i++)
        {
            System.out.println(memo[i]);
            ans= Math.max(ans,memo[i]);
        }
        return ans;
    }
}