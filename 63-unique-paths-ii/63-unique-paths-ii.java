class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     return countpaths(obstacleGrid , obstacleGrid.length ,obstacleGrid[0].length , 0 , 0, new HashMap<>());
    }
    public int countpaths(int[][] grid ,int m , int n , int row , int col , HashMap<String,Integer> memo){
        
        if(row == m-1 && col == n-1 && grid[row][col]!=1)
            return 1;
        
        if( row >= m || col >= n || row < 0 || col<0 || grid[row][col] == 1){
            
            return 0;
        }
        
        String key = row + "_" + col;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = countpaths(grid ,m , n , row , col + 1 , memo);
        int down = countpaths(grid ,m , n , row + 1, col , memo);
        
        memo.put( key , right + down);
        
        return memo.get(key);
    }
}