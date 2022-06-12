class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int answer[] = new int[2];
        
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            if(nums[mid] == target)
            {
                ans = mid;
                end = mid - 1;
            }
            
            if(nums[mid] < target)
                start = mid + 1;
            
            if(nums[mid] > target)
                end = mid - 1;
        }
        
        answer[0] = ans;
        
        if(ans == -1)
        {
            answer[1] = -1;
            return answer;
        }
        ans = -1;
        start = 0;
        end = nums.length - 1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            if(nums[mid] == target)
            {
                ans = mid;
                start = mid + 1;
            }
            
            if(nums[mid] < target)
                start = mid + 1;
            
            if(nums[mid] > target)
                end = mid - 1;
        }
        
        answer[1] = ans;
        
        return answer;
    }
}