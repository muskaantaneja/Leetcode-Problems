class Solution {
    public int uniquePaths(int m, int n) {
        
        return countpaths(m , n , 0 , 0, new HashMap<>());
    }
    public int countpaths(int m , int n , int row , int col , HashMap<String,Integer> memo){
        
        if(row == m-1 && col == n-1)
            return 1;
        
        if( row >= m || col >= n || row < 0 || col<0){
            
            return 0;
        }
        
        String key = row + "_" + col;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int right = countpaths(m , n , row , col + 1 , memo);
        int down = countpaths(m , n , row + 1, col , memo);
        
        memo.put( key , right + down);
        
        return memo.get(key);
    }
}