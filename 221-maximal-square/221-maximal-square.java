class Solution {
    public int maximalSquare(char[][] matrix) {
        HashMap<String,Integer> memo = new HashMap<>();
        int ans = 0;
        
        for(int i = 0 ; i < matrix.length ; i++)
        {
            for(int j = 0 ; j < matrix[0].length ; j++)
            {
                String key = i + "_" + j;
                if(!memo.containsKey(key) || matrix[i][j] != '0')
                    ans = Math.max(ans , maximumArea(matrix , i , j , memo));
            }
        }
                                   
        return ans * ans;                         
    }
    public int maximumArea(char[][] matrix , int row , int col , HashMap<String,Integer> memo){
        
        if(row < 0 || row >= matrix.length || col<0 || col>=matrix[0].length || matrix[row][col] == '0')
            return 0;
        
        String key = row + "_" + col;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int down =  maximumArea(matrix , row + 1 , col , memo);
        int right =  maximumArea(matrix , row  , col + 1, memo);
        int downright = maximumArea(matrix , row + 1  , col + 1, memo);
        
        memo.put(key ,1 +  Math.min(down , Math.min(right , downright)));
        
        return memo.get(key);
    }
                                   
}