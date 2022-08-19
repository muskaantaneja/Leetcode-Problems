class Pair implements Comparable<Pair> {
    int vertex;
    int cost;
    Pair(int vertex , int cost)
    {
        this.vertex = vertex;
        this.cost = cost;
    }
    
    public int compareTo(Pair o){
        return this.cost-o.cost;
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        for(int i = 0 ; i<=n ;i++ )
            adj.add(new ArrayList<>());
        
        for(int[] i : times)
        {
            int src = i[0];
            int dest = i[1];
            int weight = i[2];
            
            ArrayList<ArrayList<Integer>> list = adj.get(src);
            ArrayList<Integer> in = new ArrayList<>();
            in.add(dest);
            in.add(weight);
            list.add(in);
            
            adj.set(src , list);
        }
        int[] ans = dijkstra(n+1 ,adj,k );
        int maxi = 0;
        for(int i = 1 ; i<= n ; i++)
        {
            if(ans[i] == -1)
                    return -1;
                else
                    maxi = Math.max(ans[i] , maxi);
            
        }
        return maxi;
    }
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        int costs[] = new int[V];
        Arrays.fill(costs,-1);
        costs[S] = 0;
        pq.add(new Pair(S,0));
        
        HashSet<Integer> visited = new HashSet<>();
        
        while(pq.size() > 0){
            Pair cn = pq.remove();
            
            int cc = cn.cost;
            int current = cn.vertex;
            
            if(visited.contains(current))
            continue;
            
            visited.add(current);
            costs[current] = cc;
            for(ArrayList<Integer> i : adj.get(current))
            {
                if(!visited.contains(i.get(0)))
                pq.add(new Pair(i.get(0) , cc+i.get(1)));
            }
            
        }
        
       return costs; 
    }
}



