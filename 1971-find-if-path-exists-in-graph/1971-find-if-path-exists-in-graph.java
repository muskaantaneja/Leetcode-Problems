class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i = 0 ;i<n ;i++)
        {
            graph.put(i,new ArrayList<>());
        }
        
        for(int[] i: edges)
        {
            List<Integer> arr=graph.get(i[0]);
            arr.add(i[1]);
            graph.put(i[0],arr);
            
            arr = graph.get(i[1]);
            arr.add(i[0]);
            graph.put(i[1],arr);
        }
        
        return pathfounder(graph,source,destination,new HashSet<>());
    }
    
    private boolean pathfounder(HashMap<Integer,List<Integer>> graph,int source,int destination, HashSet<Integer> set)
    {
        if(source==destination)
            return true;
        
        set.add(source);

        boolean h = false;
        for(int current: graph.get(source))
        {
             if(!set.contains(current))
            h = h || pathfounder(graph,current,destination,set);
            if(h == true)
                return h;
        }
        
        return false;
        
        
    }
}