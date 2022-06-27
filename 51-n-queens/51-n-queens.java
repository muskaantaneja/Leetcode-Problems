class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> ans = new ArrayList<>();
        char[][] grid = new char[n][n];
        
        for(char[] i : grid)
            Arrays.fill( i , '.');
            
        nqueens( 0 , n , grid , ans);
        return ans;
    }
    
    public void nqueens( int row , int n , char[][] grid , List<List<String>> ans){
        
        if(row == n){
            
           List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String temp=new String();
                for(int j=0;j<n;j++)
                {
                    temp=temp+grid[i][j];
                }
                list.add(temp);
            }
           ans.add(list);
            return;
           // return;
        }
        
        for(int col = 0 ; col < n ; col++){
            
            if(isvalid(row , col , grid)){
                grid[row][col] = 'Q';
                
                nqueens(row + 1 , n , grid , ans);
                
                grid[row][col] = '.';
            }
        }
        
        return;
    }
    
    public boolean isvalid(int row , int col , char[][] grid){
        
        return validrow(row , grid) && validcol(col , grid) && validdiagonal(row,col,grid);
    }
    
    public boolean validrow(int row , char[][] grid){
        
        int n = grid.length;
        
        for(int col = 0 ; col<n ; col++){
            
            if(grid[row][col] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean validcol(int col , char[][] grid){
        
        int n = grid.length;
        
        for(int row = 0 ; row<n ; row++){
            
            if(grid[row][col] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
     public boolean validdiagonal(int row ,int col , char[][] grid){
        
        int n = grid.length;
        
        int i = row;
        int j = col;
        
        while(i >= 0 && j>=0){
            
            if(grid[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        } 
        
         i = row;
         j = col;
        
        while(i >= 0 && j<n ){
            
            if(grid[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        } 
         
        i = row;
        j = col;
        
        while(i < n && j >= 0 ){
            
            if(grid[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        } 
         
        i = row;
        j = col;
        
        while(i < n && j < n ){
            
            if(grid[i][j] == 'Q'){
                return false;
            }
            i++;
            j++;
        }  
        return true;
    }
}