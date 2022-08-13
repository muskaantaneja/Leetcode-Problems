class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartitioning(s, 0, s.length()-1 , ans,new ArrayList<>());
        return ans; 
    }
    public void palindromePartitioning(String s , int start , int end ,List<List<String>> ans , List<String> list){
        
        if(start > end ){
           // list.add(s.substring(start , end+1));
            ans.add(new ArrayList<>(list));
           // list.remove(list.size()-1);
            return;
        }
        
        
        for(int i = start ; i <= end ; i++){
            if(ispalindrome(s , start , i)){
                list.add(s.substring(start , i+1));
                palindromePartitioning(s ,i+1 , end ,ans , list );   
                list.remove(list.size()-1);
            }
        }
        
        return ;
    }
   private boolean ispalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}