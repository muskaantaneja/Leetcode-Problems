class Solution {
    public int findLongestChain(int[][] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        
        sortbyColumn(nums, 0);
        Arrays.fill(memo,1);
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i ;j++)
            {
                if(nums[i][0]>nums[j][1] && j!=i)
                    memo[i] = Math.max(memo[j]+1,memo[i]);
            }
        }
        int ans=0;
        for(int i=0; i<n; i++)
        {
            //System.out.println(memo[i]);
            ans= Math.max(ans,memo[i]);
        }
        return ans;
    }
    
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {
            
       //   @Override              
          // Compare values according to columns
          public int compare(final int[] entry1, 
                             final int[] entry2) {
  
            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });  // End of function call sort().
    }
}