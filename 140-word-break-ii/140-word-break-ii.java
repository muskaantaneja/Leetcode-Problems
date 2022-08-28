class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      HashMap<String , Boolean> memo = new HashMap<>();
        List<String> ans = new ArrayList<>();
         checkWords(s , 0 , 0 , wordDict,"" , ans);
        return ans;
    }
    public void checkWords(String s , int start , int end , List<String> wordDict,String str,List<String> ans)
    {
        String key = s.substring(start,end+1);
        if(end == s.length()-1)
        {
            if(wordDict.contains(key))
            {
                str = str + key;
                ans.add(str);
            }
            return;
        }
        
       if(wordDict.contains(key))
             checkWords(s , end + 1 , end + 1 , wordDict , str + key + " " , ans);
         checkWords(s , start , end + 1 ,wordDict ,  str , ans);
        
        //memo.put(checker , consider||notconsider);
        
        return ;
    }
}