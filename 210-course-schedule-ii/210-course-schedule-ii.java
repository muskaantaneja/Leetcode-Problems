class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> traversal=new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0; i<numCourses; i++)
            graph.put(i , new ArrayList<>());
        
        for(int i =0; i<prerequisites.length ; i++)
        {
            ArrayList<Integer> arr = graph.get(prerequisites[i][1]);
            arr.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1],arr);
        }
        
        for(int i=0;i<numCourses;i++)
        {
            if(!visited.contains(i))
            {
                 if(topologicalorder( graph,i,visited,new HashSet<>(),traversal)==true)
                     return new int[0];
            }
        }
        
        int[] answer = new int[numCourses];
        
        int k =0;
        for(int i=traversal.size()-1;i>=0;i--)
        {
            answer[k]=traversal.get(i); 
            k++;
        }
        
        return answer;
    }
    private boolean topologicalorder(HashMap<Integer,ArrayList<Integer>> graph,
              int current,HashSet<Integer>visited,HashSet<Integer>recstack, ArrayList<Integer> traversal)
    {
        if(visited.contains(current))
        {
            if(recstack.contains(current))
                return true;
            return false;
        }
        
        visited.add(current);
        recstack.add(current);
        
        for(int i : graph.get(current))
        {
            if(topologicalorder( graph,i,visited,recstack,traversal)==true)
                return true;
           // return false;
        }
        
        recstack.remove(current);
        traversal.add(current);
        
        return false;
    }
}