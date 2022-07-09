class Solution {
    public int minPathSum(int[][] grid) {
       // int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n+1][m+1];
        
       return minpathSum(grid , 0 , 0, n ,m, memo);
    }
    static int minpathSum(int grid[][] , int row , int col , int n ,int m , int[][] memo)
    {
        if(row >= n || col>= m || col<0 || row<0)
        return 1000000;
        
        if(row == n-1 && col == m-1)
        return grid[row][col];
        
        if(memo[row][col] != 0)
        return memo[row][col];
        
        int down = grid[row][col] + minpathSum(grid , row + 1 , col , n ,m, memo);
        int right = grid[row][col] + minpathSum(grid , row  , col + 1, n , m ,memo);
        
        memo[row][col] = Math.min(down , right);
        
        return memo[row][col];
    }
}