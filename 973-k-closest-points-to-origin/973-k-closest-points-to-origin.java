class Pair implements Comparable<Pair>{
    int dist;
    int x , y;
    Pair(int dist , int x , int y)
    {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
    public int compareTo(Pair o){
        
        return this.dist - o.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int[] current : points){
            
            pq.add(new Pair(current[0]*current[0] + current[1] * current[1] , current[0] , current[1]));
            
            while(pq.size() > k)
                pq.poll();
        }
        int index = 0;
        for(Pair currentpair : pq){
            
            ans[index][0] = currentpair.x;
            ans[index][1] = currentpair.y;
            index++;
        }
        
        return ans;
    }
}