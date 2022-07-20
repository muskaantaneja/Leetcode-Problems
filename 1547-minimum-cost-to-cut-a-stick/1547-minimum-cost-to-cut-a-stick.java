class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(0);
        for(int i : cuts)
            arr.add(i);
        
        arr.add(n);
        
        return minimumcost( arr );
    }
    public int minimumcost( ArrayList<Integer> arr){
        
        int[][] dp = new int[arr.size()][arr.size()];
        
        
        for(int i = arr.size()-2 ; i>=1 ; i--)
        {
            for(int j = 1 ; j<= arr.size()-2; j++)
            {
                if(i>j)
                    continue;
                int ans = 10000000;
        
                for(int k = i ; k <= j ; k++)
                {
                    ans = Math.min(ans , arr.get(j+1) - arr.get(i-1) +
                           dp[i][k-1] + dp[k+1][j] );
                }
                dp[i][j] = ans;
            }
        }
       
      
        return dp[1][arr.size()-2];
    }
}