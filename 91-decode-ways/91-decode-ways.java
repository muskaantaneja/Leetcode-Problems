class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> memo = new HashMap<>();
        return decodeWays(s, 0, memo);
    }
    
    int decodeWays(String s, int idx, Map<String, Integer> memo){
       if(idx < s.length() && s.charAt(idx) == '0')
            return 0;
        
        // If idx has reached the last character
        if(idx >= s.length() - 1)
            return 1;
        
        // If already found this string earlier
        String key = s.substring(idx);
        if(memo.containsKey(key))
            return memo.get(key);
    
        // Choice 1: when considering the current char as single alphabet
        int choice1 = decodeWays(s, idx + 1, memo);
        
        // Choice 2: when considering the current char and the next char together and checking if that is a valid alphabet
        int combined = (s.charAt(idx) - 48) * 10 + (s.charAt(idx+1) - 48);
        int choice2 = 0;
        if(combined <= 26)
            choice2 = decodeWays(s, idx+2, memo);
        memo.put(key, choice1 + choice2);
        return choice1 + choice2;
    }
}