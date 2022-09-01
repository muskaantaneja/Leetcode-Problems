class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;
        
        for(int current : nums)
            xor = xor^current;
        
        int rightMostSetBit = (xor & -xor);
        
        
        int xor1 = 0;
        for(int current : nums)
        {
            
            if((rightMostSetBit & current) == 0)
            {
                xor1 ^= current;
            }
        }
        
        int ans[] = new int[2];
        
        ans[0] = xor1;
        ans[1] = xor1 ^ xor;
        
        return ans;
    }
}