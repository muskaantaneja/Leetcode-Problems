class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)
            sum=sum+i;
        if(sum%2!=0)
            return false;
        return subsetsum(nums.length,nums,sum/2);
    }
    private Boolean subsetsum(int n ,int arr[], int sum)
    {
       boolean[][] dp = new boolean[n+1][sum+1];
       for(int i=0 ; i < n+1 ; i++)
       {
         for(int j =0 ;j<sum+1 ; j++)
           {
               if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
           }
       }
       for(int i = 1; i<n+1 ;i++)
       {
           for(int j =1 ;j<sum+1 ; j++)
           {
               if(arr[i-1]<= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
               else
                    dp[i][j] = dp[i-1][j];
           }
       }
        
        return dp[n][sum];
            
    }
}