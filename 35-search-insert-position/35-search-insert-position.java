class Solution {
    public int searchInsert(int[] arr, int target) {
        
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            if(arr[mid] == target)
                return mid;
            
            if(arr[mid] < target){
                ans = mid;
                start = mid + 1;
            }
            
            if(arr[mid] > target)
                end = mid - 1;
        }
        
        return ans+1;
        
    }
}