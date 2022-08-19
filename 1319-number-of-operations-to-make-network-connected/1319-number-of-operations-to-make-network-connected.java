class Solution {
    public int makeConnected(int n, int[][] connections) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] i : connections)
        {
            map.put(i[0] , map.getOrDefault(i[0] , new ArrayList<>()));
            map.put(i[1] , map.getOrDefault(i[1] , new ArrayList<>()));
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();
         for(int i = 0 ; i< n ; i++)
        {
             if(!map.containsKey(i))
                 map.put(i , new ArrayList<>());
         }
        for(int i = 0 ; i< n ; i++)
        {
            if(!visited.contains(i))
            {
                ans += 1;
                dfs(map , i , visited);
            }
        }
        int res = connections.length;
        if(n-1 > res)
            return -1;
        return ans-1;
    }
    public void dfs(HashMap<Integer,List<Integer>> graph , int current,HashSet<Integer> visited){
        
        if(visited.contains(current))
            return;
        
        visited.add(current);
        for(int node : graph.get(current)){
            
            dfs(graph,node,visited);
        }
        return;
    }
}