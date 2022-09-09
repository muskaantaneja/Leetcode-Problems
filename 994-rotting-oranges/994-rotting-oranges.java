class Pair{
    int row;
    int col;
    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
         int count = 0 , ans = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                queue.add(new Pair(i , j));
                if(grid[i][j] == 1)
                count++;
            }
        }
      
        while(queue.size() > 0)
        {
            int cs = queue.size();
            //ans+=1;
            
            while(cs > 0)
            {
                cs--;
               Pair current = queue.poll();
               int row = current.row;
               int col = current.col;
               if(row >= grid.length || col >= grid[0].length || row<0 || col<0 ||                  grid[row][col] == 0
               || grid[row][col] == -1)
               continue;
               
               if(grid[row][col] == 1)
               count--;
               
               grid[row][col] = -1;
            
               queue.add(new Pair(row + 1 , col));
               queue.add(new Pair(row -1 , col));
               queue.add(new Pair(row  , col - 1));
               queue.add(new Pair(row, col + 1));
               
            }
            if(count <= 0)
            return ans;
            ans += 1;
        }
        if(count > 0)
        return -1;
        
        return ans;
    }
}