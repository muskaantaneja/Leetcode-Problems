class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(0);
        for(int i : cuts)
            arr.add(i);
        
        arr.add(n);
        
        return minimumcost(1 , arr.size()-2 , arr ,new HashMap<>());
    }
    public int minimumcost(int i , int j , ArrayList<Integer> arr, HashMap<String , Integer> memo){
        
        if(i > j)
            return 0;
        
        String key = i + "_" + j;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        int ans = 10000000;
        
        for(int k = i ; k <= j ; k++)
        {
            ans = Math.min(ans , arr.get(j+1) - arr.get(i-1) +
                           minimumcost(i , k-1, arr , memo) + minimumcost(k+1 , j , arr, memo));
        }
        
        memo.put(key , ans);
        return ans;
    }
}