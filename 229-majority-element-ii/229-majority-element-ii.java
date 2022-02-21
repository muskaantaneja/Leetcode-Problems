class Solution {
    public List<Integer> majorityElement(int[] nums) {
    HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            if( !map.containsKey(i) )
                map.put(i,0);
            
            int j = map.get(i)+1;
            map.put(i,j);
        }
        
        List<Integer> list = new ArrayList<>();
        int k = nums.length/3;
        for(int i : map.keySet())
        {
            if( map.get(i) > k)
            {
                list.add(i);
            }
        }
        
        return list;
    }
}