class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for(int i =0;i<board.length;i++)
        {
            for(int j =0;j<board[0].length ; j++)
            {
                if(board[i][j] == word.charAt(0))
                ans = ans || checkgrid(board , word , i, j , 0,new HashSet<>());
            }
        }
        return ans ;
    }
    public boolean checkgrid(char[][] board , String word, int r, int c,int currentindex,HashSet<String> set)
    {
        
        if(currentindex >= word.length())
            return true;
        
        if(c<0 || r<0 || r>=board.length || c>=board[0].length )
            return false;
        
        
        String key = r + "_" + c;
        
        if(set.contains(key))
            return false;
        
        set.add(key);
        boolean left=false,right=false,down=false,up=false;
        if(board[r][c] == word.charAt(currentindex))
        {
            left = checkgrid(board , word, r, c-1,currentindex+1,set);
            right = checkgrid(board , word, r, c+1,currentindex+1,set);
            up = checkgrid(board , word, r-1, c,currentindex+1,set);
            down = checkgrid(board , word, r+1, c,currentindex+1,set);
        }
        
        set.remove(key);
        return left || right || up || down; 
    }
}