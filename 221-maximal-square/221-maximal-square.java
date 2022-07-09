class Solution {
    public int maximalSquare(char[][] matrix) {
        
        HashMap<String , Integer> memo = new HashMap<>();
        int n = matrix.length;
        int m = matrix[0].length;
        
        int ans =0;
        
        for(int row = 0 ; row < n ; row++)
        {
            for(int col = 0 ; col<m ; col++){
                
                String key = row + "_" + col;
                
                if(!memo.containsKey(key) || matrix[row][col] != '0')
                    ans = Math.max(ans, maximumsquare( matrix ,row , col , n , m , memo));
            }
        }
        
        return ans*ans;
    }
    
    public int maximumsquare(char matrix[][] ,int row , int col , int n , int m , HashMap<String , Integer> memo)
    {
        
        if(row < 0 || col < 0 || row>=n || col>=m || matrix[row][col] =='0' )
            return 0;
        
       
        String key = row + "_" + col;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int down =  maximumsquare( matrix ,row+1 , col , n , m , memo);
        int down_right = maximumsquare( matrix ,row+1 , col+1 , n , m , memo);
        int right =   maximumsquare( matrix ,row , col+1 , n , m , memo);
        
        memo.put(key , 1 + Math.min(down , Math.min(down_right , right)));
        
        return memo.get(key);
    }
}