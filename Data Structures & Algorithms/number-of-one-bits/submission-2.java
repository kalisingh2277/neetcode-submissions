class Solution {
    public int hammingWeight(int n) {
        // int sum=0;
        // int i=1;
        // while(i<=32)
        // {
        //     if((n&1)==1)
        //     {
        //         sum++;
        //     }
        //     n=n>>1;
        //     i++;
        // }
        // return sum;
        int res=0;
        while(n!=0)
        {
            n=n&(n-1);
            res++;
        }
        return res;
    }
}
