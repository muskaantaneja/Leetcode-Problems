class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String , Boolean> memo = new HashMap<>();
        return checkWords(s , 0 , 0 , wordDict,memo);
    }
    public boolean checkWords(String s , int start , int end , List<String> wordDict,HashMap<String , Boolean> memo)
    {
        String key = s.substring(start,end+1);
        if(end == s.length()-1)
        {
            if(wordDict.contains(key))
                return true;
            return false;
        }
        
        String checker = start + "_" + end;
        
        if(memo.containsKey(checker))
            return memo.get(checker);
        
        boolean consider = false;
        if(wordDict.contains(key))
             consider = checkWords(s , end + 1 , end + 1 , wordDict , memo);
         boolean notconsider = checkWords(s , start , end + 1 , wordDict , memo);
        
        memo.put(checker , consider||notconsider);
        
        return consider || notconsider;
    }
}