class Solution {
    public int subarraysWithKDistinct(int[] S, int K) {
      return atmostkdistinct(S,K) - atmostkdistinct(S,K-1);
    }
    
     public int atmostkdistinct(int[] s , int k){

        HashMap<Integer,Integer> memo = new HashMap<>();
        int left = 0;
        int ans = 0;
        
        for(int right = 0; right<s.length ; right++){
            int currentchar = s[right];
            memo.put(currentchar , memo.getOrDefault(currentchar , 0) + 1);

            while(memo.size() > k && left<=right){
                    int count = memo.get(s[left]);
                    count--;

                    if(count == 0)
                    memo.remove(s[left]);
                    else
                    memo.put(s[left] , count);
                    
                    left++;
            }

            //if(memo.size() > 0 && memo.size() <= k )
            ans += right - left + 1;
        } 

        return ans;
    }
}
