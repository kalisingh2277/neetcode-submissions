class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int i=0;i<nums.length;i++)
        {
            xor^=nums[i];
        }
        for(int i=0;i<=n;i++)
        {
            xor^=i;
        }
        return xor;
    }
}