class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int arr[] : dp)
            Arrays.fill(arr , 200000);
        
        for(int col = 0; col < m ; col++)
        {
            dp[0][col] = grid[0][col];
        }
        
        for(int row = 0 ; row < n ; row++ ){
            
            for(int col = 0; col < m ; col++ )
            {
                
                if(row + 1 < n)
                {
                    dp[row + 1][col] = Math.min(dp[row][col] + grid[row+1][col],dp[row+1][col]);
                    
                    if(col - 1 >= 0)
                        dp[row + 1][col- 1] = Math.min(dp[row][col] + grid[row+1][col -1],dp[row+1][col - 1 ]);
                    
                    if(col + 1 < m)
                        dp[row + 1][col + 1] = Math.min(dp[row][col] + grid[row+1][col + 1],dp[row+1][col +1 ]);
                }
            }
        }
        int ans = 100000;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans , dp[n-1][i]);
        }
        return ans;
}
    }