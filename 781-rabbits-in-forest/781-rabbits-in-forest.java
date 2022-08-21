class Solution {
    public int numRabbits(int[] answers) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int current : answers)
            map.put(current , map.getOrDefault(current , 0) + 1);
        
        for(int currentval : map.keySet()){
            
           ans += ((int)Math.ceil((double)map.get(currentval) /( currentval+1))) * (currentval+1) ; 
           
        }
        return ans;
    }
}