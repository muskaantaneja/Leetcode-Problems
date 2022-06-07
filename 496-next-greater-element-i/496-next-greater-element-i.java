class Solution {
    public int[] nextGreaterElement(int[] nums2, int[] nums1) {
        
        int nge[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums1.length-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && stack.peek() < nums1[i])
                stack.pop();
            if( stack.isEmpty() )
            {
                
                nge[i] =-1;
            }
            else
            nge[i] = stack.peek();
            
            stack.push(nums1[i]);
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i =0 ; i < nums1.length ; i++){
            map.put(nums1[i] , nge[i]);
        }
        
        int ans[] = new int[nums2.length];
        
        for(int i = 0 ; i<nums2.length ; i++){
            
            if(map.containsKey(nums2[i]))
            ans[i] = map.get(nums2[i]);
        }
        return ans;
    }
}