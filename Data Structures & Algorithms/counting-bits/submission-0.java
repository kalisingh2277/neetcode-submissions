class Solution {
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int val=check_1(i);
            arr[i]=val;
        }
        return arr;
    }
    public static int check_1(int num)
    {
        int res=0;

        while(num!=0)
        {
            num=num&(num-1);
            res++;
        }
        return res;
    }
}