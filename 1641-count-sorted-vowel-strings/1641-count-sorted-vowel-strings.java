class Solution {
    public int countVowelStrings(int n) {
        if(n==1)
            return 5;
        int[] nums = new int[5];
        nums[0] = 5; 
        nums[1] = 4;
        nums[2] = 3;
        nums[3] = 2;
        nums[4] = 1;
        int sum = 15;
        
        if(n==2)
            return sum;
        
        for(int i = 3 ; i <= n;i++)
        {
            int temp = nums[0];
            nums[0] = sum;
            int h = nums[1];
            nums[1] = sum - temp;
            temp = nums[2];
            nums[2] =  nums[1] - h;
            h = nums[3];
            nums[3] =  nums[2] - temp;
            nums[4] = 1;
            sum = nums[0] + nums[1] + nums[2] +nums[3]+nums[4];
        }
        return sum;
    }
}