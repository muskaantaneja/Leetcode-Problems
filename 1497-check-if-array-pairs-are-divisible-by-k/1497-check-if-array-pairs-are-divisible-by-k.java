class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int i : arr){
            
            int rem = 0;
            
            if(i>=0)
                rem = i%k;
            else
                rem = ((i%k) + k )% k;
            
            map.put( rem , map.getOrDefault(rem , 0) + 1);
        }
        
        for(int i : map.keySet()){
            if(i == 0){
                if(map.get(i) % 2 == 0)
                    map.put(i , 0);
                else
                    return false;
                continue;
            }
            
            if(map.get(i) == 0)
                continue;
            
            int a = map.get(i);
            int b = map.getOrDefault(k - i , 0);
            
            if(a == b)
            {
                map.put(i,0);
                map.put( k-i , 0 );
            }
            else
                return false;
        }
        
        return true;
    }
}