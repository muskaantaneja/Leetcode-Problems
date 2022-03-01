class Solution {
    public int maxAreaOfIsland(int[][] grid) {
    int ans =0;
    int arr[] = new int[1];
       for(int i=0;i<grid.length;i++)
       {
           for(int j =0;j<grid[0].length;j++)
           {
               if(grid[i][j]==1)
               {
                   arr[0]=0;
                   fillcolor(grid,i,j,arr);
                   ans = Math.max(arr[0],ans);
               }
           }
       }
        return ans;
    }
    private void fillcolor(int[][] image, int sr, int sc,int arr[])
    {
        if(sr < 0 || sr>=image.length || sc<0 || sc>=image[0].length)
            return ;
        
        if(image[sr][sc] == 1)
        {
            image[sr][sc]=0;
            arr[0] = arr[0] +1;
            fillcolor(image,sr+1,sc,arr);
            fillcolor(image,sr-1,sc,arr);
            fillcolor(image,sr,sc+1,arr);
            fillcolor(image,sr,sc-1,arr);
        }
        
        return;
    }
} 