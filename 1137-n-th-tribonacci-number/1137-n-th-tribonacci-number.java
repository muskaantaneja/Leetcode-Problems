class Solution {
    public int tribonacci(int n) {
     return tribo( n , new HashMap());
    }
    
    public int tribo(int current , HashMap<Integer , Integer> memo){
        
        if(current == 0 || current == 1)
            return current;
        
        if(current == 2)
            return 1;
        
        if(memo.containsKey(current))
            return memo.get(current);
        
        int first = tribo(current - 1 , memo);
        int second = tribo(current - 2 , memo);
        int third = tribo(current-3 , memo);
        
        memo.put(current , first + second + third);
        
        return memo.get(current);
    }
}