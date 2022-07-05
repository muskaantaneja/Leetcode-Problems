class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> memo = new HashMap<>(); 
        int startfromZero =  minimumcost(cost , 0 , cost.length , memo);
        int startfromOne =  memo.get(1);
        
        return Math.min(startfromZero , startfromOne);
    }
    
    public int minimumcost( int[] cost , int current , int target , HashMap<Integer , Integer> map){
        
        if(current >= target)
            return 0;
        
        if(map.containsKey( current ))
            return map.get(current);
        
        int onestep = minimumcost(cost , current+1 , target , map);
        int twostep = minimumcost(cost , current+2 , target , map);
        
        map.put(current , cost[current] + Math.min(onestep , twostep));
        
        return map.get(current);
    }
}