class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int prev = 0;
        int ans = 0;
        
        for(int current = 0 ; current < s.length() ; current++){
            
            char key = s.charAt(current);
            
            if(map.containsKey(key))
            {
                if(map.get(key) >= prev)
                prev = map.get(key) + 1;
            }
            
            map.put(key , current);
            
            ans = Math.max(ans , current - prev + 1);
        }
        
        return ans;
    }
}