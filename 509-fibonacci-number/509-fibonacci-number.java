class Solution {
    public int fib(int n) {
        
        return fibbo( n , new HashMap());
    }
    
    public int fibbo(int current , HashMap<Integer , Integer> memo){
        
        if(current == 0 || current == 1)
            return current;
        
        if(memo.containsKey(current))
            return memo.get(current);
        
        int first = fibbo(current - 1 , memo);
        int second = fibbo(current - 2 , memo);
        
        memo.put(current , first + second);
        
        return memo.get(current);
    }
}