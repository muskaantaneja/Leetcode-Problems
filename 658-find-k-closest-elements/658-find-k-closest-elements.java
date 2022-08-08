class Pair implements Comparable<Pair>{
    int diff;
    int val;
    Pair(int diff , int val)
    {
        this.diff = diff;
        this.val = val;
    }
    public int compareTo(Pair o){
        if(this.diff == o.diff)
            return this.val - o.val;
        return this.diff - o.diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int current : arr){
            
            pq.add(new Pair(Math.abs(current - x) , current));
            
            while(pq.size() > k )
                pq.poll();
            
        }
        
        List<Integer> ans = new ArrayList<>();
        for(Pair currentpair : pq){
            ans.add(currentpair.val);
        }
        Collections.sort(ans);
        return ans;
    }
}