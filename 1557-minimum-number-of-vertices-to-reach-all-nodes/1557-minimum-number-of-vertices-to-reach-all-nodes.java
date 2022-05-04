class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> visited = new HashSet<>();
        
        for(List<Integer> i : edges)
            visited.add(i.get(1));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i =0; i < n ; i++)
        {
            if(!visited.contains(i))
                list.add(i);
        }
        return list;
    }
}