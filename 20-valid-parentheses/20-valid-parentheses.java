class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
        for(int i =0; i<s.length() ; i++){
            
            char currentchar = s.charAt(i);
            
            if(currentchar == '{' || currentchar == '[' || currentchar == '('){
                stack.push(currentchar);
            }
            
            else {
                if(stack.size() == 0)
                    return false;
                
                int stackelement = stack.peek();
                if(currentchar == ')' && stackelement != '(')
                    return false;
                else if(currentchar == ']' && stackelement != '[')
                    return false;
                else if(currentchar == '}' && stackelement != '{')
                    return false;
                stack.pop();
                
            }
        }
        
        if(stack.size() > 0)
        return false;
        
        return true;
    }
}