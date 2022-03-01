class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        fillgraph(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    private void fillgraph(int[][] image,int sr,int sc,int newcolor,int val)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=val)
            return;
        
        image[sr][sc] = newcolor;
        fillgraph(image,sr+1,sc,newcolor,val);
        fillgraph(image,sr,sc+1,newcolor,val);
        fillgraph(image,sr-1,sc,newcolor,val);
        fillgraph(image,sr,sc-1,newcolor,val);
        
        return ;
    }
}