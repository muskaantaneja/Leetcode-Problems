class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        
        int[][] dp = new int[n][n];
        
        for(int arr[] : dp)
            Arrays.fill(arr , 200000);
        
       dp[0][0] = Math.min(dp[0][0] , triangle.get(0).get(0));
        
        for(int row = 0 ; row < n ; row++){
            
            int m = triangle.get(row).size();
            
            for(int col = 0; col < m ; col++)
            {
                
                if(row + 1 < n)
                {
                    dp[row + 1][col] = Math.min(dp[row][col] +
                    triangle.get(row+1).get(col),dp[row+1][col]);
                    
                    if(col + 1 < m+1)
                        dp[row+1][col+1] = Math.min(dp[row][col] + 
                        triangle.get(row+1).get(col+1),dp[row+1][col+1]);
                    
                }
            }
        }
        
        int ans = 10000000;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans , dp[n-1][i]);
        }
        return ans;
    }
}