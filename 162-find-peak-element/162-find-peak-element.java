class Solution {
    public int findPeakElement(int[] nums) {
        
        int start =0;
        int end = nums.length - 1;
        
        while(start<end){
            
            System.out.println(start +"  "+end);
            
            int mid = start + (end - start)/2;
            
            // if(start == end )
            //     return start;
            
//              if(nums[mid+1] < nums[mid])
//                 return mid;
            
//             if(nums[mid] < nums[mid-1])
//                 return mid-1;
            
            
            if(nums[mid] <= nums[mid+1]){

                    start = mid + 1;
            }
            else
            {
            
                    end = mid;
            }
        }
        
        return start;
}
}