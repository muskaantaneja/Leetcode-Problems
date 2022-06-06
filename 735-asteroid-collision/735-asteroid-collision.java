class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int currentstone : asteroids){
            
            if(stack.isEmpty() || currentstone > 0)
                stack.push(currentstone);
            
             else{
                 while( !stack.isEmpty() && stack.peek() < -currentstone && stack.peek() > 0 )
                     stack.pop();
                 
                 if(stack.isEmpty())
                     stack.push(currentstone);
                 
                 else if(!stack.isEmpty() && stack.peek() < 0)
                     stack.push(currentstone);
                 
                  else if(!stack.isEmpty() && stack.peek() == -currentstone)
                     stack.pop();
            }
            
           
        }
        
        int[] ans = new int[stack.size()];
        int i = ans.length-1;
        
        while(stack.size() > 0){
            ans[i] = stack.peek();
            stack.pop();
            i--;
        }
        
        
        return ans;
    }
}