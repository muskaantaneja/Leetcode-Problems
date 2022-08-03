class Solution {
    public void solve(char[][] board) {
        int n = board.length - 1;
        int m = board[0].length - 1;
        checkboundary(board , 0 , 0 , n , 0);
        checkboundary(board , 0 , m , n , m);
        checkboundary(board , n , 0 , n , m);
        checkboundary(board , 0 , 0 , 0 , m);
      //  printboard(board , 0 , 0 , board.length-1 ,board[0].length-1);
        checkinnerboard(board , 0 , 0 , n , m);
        // printboard(board , 0 , 0 , board.length-1 ,board[0].length-1);
        finalboard(board , 0, 0 , n , m);
        
        
        return ;
    }
    public void printboard(char[][] board , int row , int col , int n , int m){
        for(int i = row ; i <= n ; i++)
        {
            for(int j = col ; j <= m ; j++)
            {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void checkboundary(char[][] board , int row , int col , int n , int m)
    {
        for(int i = row ; i <= n ; i++)
        {
            for(int j = col ; j <= m ; j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'R';
            }
        }
        
        
    }
    public void checkinnerboard(char[][] board , int row , int col , int n , int m)
    {
        HashSet<String> visited = new HashSet<>();
        for(int i = row ; i <= n ; i++)
        {
            for(int j = col ; j <= m ; j++)
            {
                if(!visited.contains(i + "_" + j) && board[i][j] == 'R')
                    fillinnerboard(board , i , j , n , m , visited);
            }
        }
    }
    public  void fillinnerboard(char[][] board , int row , int col , int n , int m , HashSet<String> visited){
        
        if(row>n || row<0 || col>m || col<0 || board[row][col] == 'X')
            return ;
        
        if(visited.contains(row + "_" + col))
            return;
        
        if(board[row][col] == 'O')
            board[row][col] = 'R';
        visited.add(row + "_" + col);
        fillinnerboard(board , row+1 , col , n , m , visited);
        fillinnerboard(board , row , col+1 , n , m , visited);
        fillinnerboard(board , row-1 , col , n , m , visited);
        fillinnerboard(board , row , col-1 , n , m , visited);
        return;
        
    }
    public void finalboard(char[][] board , int row , int col , int n , int m)
    {
        for(int i = row ; i <= n ; i++)
        {
            for(int j = col ; j <= m ; j++)
            {
                if(board[i][j] == 'R')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
}