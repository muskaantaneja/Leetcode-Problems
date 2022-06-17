class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        int ans = 0,left = 0;
        
        for(int right = 0 ; right < s.length() ; right++ )
        {
            char key=s.charAt(right);
            
            if(map.containsKey(key) && map.get(key) >= left)
            {
                
                left = map.get(key) + 1;
                
            }
            
            int a = right - left + 1;
            map.put(key , right);
            ans = Math.max(ans , a);
                
        }
        return ans;
    }
}