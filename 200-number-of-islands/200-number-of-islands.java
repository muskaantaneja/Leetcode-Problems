class Solution {
    public int numIslands(char[][] grid) {
        int ans =0;
       for(int i=0;i<grid.length;i++)
       {
           for(int j =0;j<grid[0].length;j++)
           {
               if(grid[i][j]=='1')
               {
                   ans = 1 + ans;
                   fillcolor(grid,i,j);
               }
           }
       }
        return ans;
    }
    private void fillcolor(char[][] image, int sr, int sc)
    {
        if(sr < 0 || sr>=image.length || sc<0 || sc>=image[0].length)
            return ;
        
        if(image[sr][sc] == '1')
        {
            image[sr][sc]='0';
            
            fillcolor(image,sr+1,sc);
            fillcolor(image,sr-1,sc);
            fillcolor(image,sr,sc+1);
            fillcolor(image,sr,sc-1);
        }
        
        return;
    }
} 