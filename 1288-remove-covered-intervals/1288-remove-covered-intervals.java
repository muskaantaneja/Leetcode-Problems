class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        sortbyColumn(intervals,0);
        int current=intervals[0][1];
        int count=0;
        for(int i =1;i<intervals.length;i++)
        {
            if(intervals[i][1] > current)
            {
                current = intervals[i][1];
                count++;
            }
        }
        return count+1;
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<int[]>() {
          public int compare(final int[] entry1, 
                             final int[] entry2) {
  
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });  
    }
}