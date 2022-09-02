class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        
        // for(int i=0;i<nums.length;i++) 
        //     nums[i]--;
        
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        
        fast = nums[0];
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
}
}