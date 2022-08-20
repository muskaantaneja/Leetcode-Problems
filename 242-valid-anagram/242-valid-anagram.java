class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int m = t.length();
        
        if(m!=n)
            return false;
        
        for(int i = 0 ; i<n; i++)
            map.put(s.charAt(i) , map.getOrDefault( s.charAt(i) , 0) + 1);
        
        for(int i = 0 ; i<m ; i++)
        {
            char key = t.charAt(i);
            
            if(map.containsKey(key) && map.get(key) > 0)
                map.put(key , map.get(key) - 1);
            else
                return false;
        }
        
        return true;
    }
}