class Solution {
    public int countOrders(int n) {
        long[] arr=new long[n+1];
        
        if(n==0||n==1)
            return n;
        arr[0]=0;
        arr[1]=1;
        arr[2]=6;
        
        long ans =1;
        for(int i =3;i<=n;i++)
        {
            ans=((2*i)-1)%1000000007;
            ans = (ans*i)%1000000007;
            arr[i] = (ans*arr[i-1])%1000000007;
        }
        
        int h = (int)(arr[n]%1000000007);
        return h;
    }
}