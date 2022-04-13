class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int count=0;
        for(int i =0;i<(n+1)/2;i++)
        {
            for(int j=i; j<n-i ;j++)
            {
                count++;
                mat[i][j]=count;
            }
            for(int k=i+1; k<n-i ;k++)
            {
                count++;
                mat[k][n-i-1]=count;
            }
            for(int z=n-i-2; z>=i ;z--)
            {
                count++;
                mat[n-i-1][z]=count;
            }
            for(int l=n-i-2; l>i ;l--)
            {
                count++;
                mat[l][i]=count;
            }
        }
        return mat;
    }
}