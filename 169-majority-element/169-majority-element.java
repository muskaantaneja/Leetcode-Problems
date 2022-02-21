class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : nums)
        {
            if( !map.containsKey(i) )
                map.put(i,0);
            
            int j = map.get(i)+1;
            map.put(i,j);
        }
        
        for(int i : map.keySet())
        {
           // System.out.println( i +" = "+ map.get(i));
        }
        int h =0;
        int k = nums.length/2;
        for(int i : map.keySet())
        {
            if( map.get(i) > k)
            {
                h = i;
                break;
            }
        }
        
   //     System.out.println( k +" " + h);
        return h;
    }
}