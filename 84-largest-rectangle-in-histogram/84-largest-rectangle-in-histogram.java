class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] nse = nextSmallestElement(heights);
        int[] pse = prevSmallestElement(heights);
        
        int maxi = 0;
        
        for(int i = 0 ; i<heights.length ; i++){
           // int width = nse[i] - pse[i] -1;
            if(nse[i] == -1)
                nse[i] = heights.length;
            // if(width < 0)
            //     width = 1;
            
            int width = nse[i] - pse[i] -1;
            maxi = Math.max(maxi , width*heights[i]);
        }
        
        return maxi;
    }
    
     public int[] nextSmallestElement(int[] nums1) {
        
        int nse[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums1.length-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && nums1[stack.peek()] >=nums1[i])
                stack.pop();
            if( stack.isEmpty() )
            {
               nse[i] =-1;
            }
            else
            nse[i] = stack.peek();
            
            stack.push(i);
        }
         
         return nse;
      }
    public int[] prevSmallestElement(int[] nums1) {
        
        int nse[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0 ; i<nums1.length ; i++){
            while(!stack.isEmpty() && nums1[stack.peek()] >=nums1[i])
                stack.pop();
            if( stack.isEmpty() )
            {
               nse[i] =-1;
            }
            else
            nse[i] = stack.peek();
            
            stack.push(i);
        }
         
         return nse;
}
}