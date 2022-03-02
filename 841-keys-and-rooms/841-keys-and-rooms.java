class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
       canvisit(rooms, 0 , set);
        for(int i=0; i<rooms.size();i++)
        {
            if(set.contains(i))
                continue;
            return false;
        }
        return true;
    }
    private void canvisit(List<List<Integer>> rooms , int current, HashSet<Integer> set)
    {
        if(set.contains(current))
            return ;
        
        set.add(current);
        for(int neighbour: rooms.get(current))
        {
            canvisit(rooms , neighbour, set);
        }
        return;
    }
}