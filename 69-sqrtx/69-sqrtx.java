class Solution {
    public int mySqrt(int target) {
        
        int start = 1;
        int end = target;
        int ans = -1;
        
        if(target == 0)
            return 0 ;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            long a = (long)mid * (long)mid;
            if(a == target)
                return mid;
            
            if(a < target){
                ans = mid;
                start = mid + 1;
            }
            
            if(a > target)
                end = mid - 1;
        }
        
        return ans;
    }
}