class Solution {
    public int reverseBits(int n) {
        int i=1;
        int res=0;
        while(i<=32)
        {
            int val=n&1;
            res=res<<1;
            res=res|val;
            
            n=n>>1;
            i++;
        }
        return res;
    }
}