class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        // for(int i =0;i<graph.length;i++)
        // {
        //     if(!visited.contains(i))
            sourcetotarget(graph,0,new ArrayList<>(),ans,visited);
       // }
        return ans;
    }
    private void sourcetotarget(int[][] graph,int current,ArrayList<Integer>list,List<List<Integer>> ans,HashSet<Integer> visited)
    {
         if(visited.contains(current))
            return;
        if(current==graph.length-1)
        {
            list.add(current);
            ans.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return ;
        }
        
        visited.add(current);
        list.add(current);
        for(int neighbour: graph[current])
        {
            sourcetotarget(graph,neighbour,list,ans,visited);
        }
        
        visited.remove(current);
        list.remove(list.size()-1);
        
        return;
    }
}