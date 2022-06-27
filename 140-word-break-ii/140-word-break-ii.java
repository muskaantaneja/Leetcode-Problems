class Solution {
    public List<String> wordBreak(String s, List<String> dict) 
    {
        // code here
        HashSet<String> set = new HashSet<>();
        
        for(String i : dict){
            set.add(i);
        }
        List<String> ans = new ArrayList<>();
        wordbreak( 0 , 1, s , set ,"" , ans);
        
        return ans;
    }
    
    static void wordbreak( int start , int end , String s, HashSet<String>set ,
    String str , List<String> ans){
        
        if( end == s.length())
        {
            if(set.contains(s.substring(start , end) )){
                str = str + s.charAt(end - 1);
                ans.add(str);
            }
            
            return;
        }
        
        if(set.contains(s.substring(start , end))){
            wordbreak( end , end+1, s , set ,str +  s.charAt(end-1) + " ", ans);
        }
        
         wordbreak( start , end+1, s , set ,str+s.charAt(end-1) , ans);
         
         return;
    }
}