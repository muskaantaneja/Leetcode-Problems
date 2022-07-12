class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        int dp[][]= new int[m][n];
        
        dp[m-1][n-1] = 1;
        
        for(int i = m-1 ; i >= 0 ; i--){
            
            for(int j = n-1 ; j >= 0 ; j--){
                
                if(obstacleGrid[i][j] != 1)
                if(i-1 >= 0 && obstacleGrid[i-1][j] != 1)
                    dp[i-1][j] += dp[i][j];
                if(j-1 >= 0 && obstacleGrid[i][j -1] != 1)
                    dp[i][j-1] += dp[i][j];
            }
        }
        
        return dp[0][0];
}
}