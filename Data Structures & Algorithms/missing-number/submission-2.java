class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int i=0;i<nums.length;i++)
        {
            xor^=nums[i]^(i+1);
        }
        
        return xor;
    }
}