class Solution {
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int temp=(a&b)<<1;//this will store the carry
            a=a^b;
            b=temp;//we used temp such that b value is not chnaged for the first step
        }
        return a;
    }
}