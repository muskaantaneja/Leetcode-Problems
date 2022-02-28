class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0)
            return new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        List<String> list = new ArrayList<>();
        String h ="";
        for(int i =1;i<nums.length;i++)
        {
            int c =0;
                if(nums[i]==end+1)
                {
                    end = nums[i];
                    continue;
                }
            
            if(start==end)
                list.add(Integer.toString(start));
            
            if(start!=end)
                list.add(Integer.toString(start)+"->"+Integer.toString(end));
                
            
                start = nums[i];
                end=start;
            
        }
        
        if(start==end)
                list.add(Integer.toString(start));
            
        if(start!=end)
                list.add(Integer.toString(start)+"->"+Integer.toString(end));
        
        for(String g : list)
            System.out.println(g);
        
        return list;
    }
}