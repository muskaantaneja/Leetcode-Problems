class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int ans = 0,sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0 , 1);
        
        for(int i : nums){
            
            sum += i;
            int rem = ((sum % k)+k)%k;
            
            if(map.containsKey(rem)){
                ans += map.get( rem );
                map.put( rem , map.get(rem) + 1);
            }
            else
                map.put(rem , 1);
        }
        for(int i : map.keySet())
            System.out.println( i + "_" + map.get(i));
        return ans;
    }
}