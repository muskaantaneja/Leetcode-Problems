class Solution {
    public int minPathSum(int[][] grid) {
       // int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int arr[] : dp)
            Arrays.fill(arr , 200000);
        
       dp[n-1][m-1] = Math.min(dp[n-1][m-1] , grid[n-1][m-1]);
        
        for(int row = n-1 ; row>=0 ; row--){
            
            for(int col = m-1; col>=0 ; col--)
            {
                
                if(row - 1 >= 0)
                dp[row - 1][col] = Math.min(dp[row][col] + grid[row-1][col],dp[row-1][col]);
                
                if(col - 1 >= 0)
                dp[row][col-1] = Math.min(dp[row][col] + grid[row][col-1],dp[row][col-1]);
            }
        }
        
        return dp[0][0];
    }
}