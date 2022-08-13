class Solution {
    public int numTrees(int n) {
     return findcatalan(n , new HashMap<>());
    }
    public static int findcatalan(int n , HashMap<Integer,Integer> memo)
    {
        if(n==0 || n==1)
        return 1;
        
        if(memo.containsKey(n))
        return memo.get(n);
        
        int res = 0;
        for(int i = 0 ; i<n ; i++)
        {
            int ans = findcatalan(i,memo) * findcatalan(n-i-1,memo);
            res += ans;
        }
        
        memo.put(n , res);
        return res;
    }
}