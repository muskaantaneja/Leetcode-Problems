class Solution {
    public int fib(int n) {
        
        return fibbo( n , new int[n+1]);
    }
    
    public int fibbo(int current , int memo[]){
        
        memo[0] = 0;
        if(current == 0)
            return 0;
        memo[1] = 1;
        
        for(int i = 2; i <= current ; i++)
        {
            int first = memo[i - 1];
            int second = memo[i - 2];
        
            memo[i] = first + second;
        }
        return memo[current];
    }
}