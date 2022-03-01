class Solution {
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        arr[0]=0;
        if(n==0)
            return arr;
        arr[1]=1;
        if(n>1)
        totalones(2,arr);
        // for(int i=2;i<=n;i++)
        // {
        //      arr[i]=arr[i/2]+(i%2==0?0:1);
        // }
        return arr;
    }
    public void totalones(int o,int[] arr)
    {
        if(o==arr.length-1){
            arr[o]=arr[o/2]+(o%2==0?0:1);
            return ;
        }
        arr[o]=arr[o/2]+(o%2==0?0:1);
       // System.out.println(arr[o]);
        totalones(o+1,arr);
        return ;
    }
}