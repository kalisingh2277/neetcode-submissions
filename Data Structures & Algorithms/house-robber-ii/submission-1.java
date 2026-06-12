class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int temp1[]=new int[nums.length];
        int temp2[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            //not adding the first element
            if(i!=0)
                temp1[i]=nums[i];
            //not adding the last element
            if(i!=nums.length-1)
                temp2[i]=nums[i];
        }
        // returning the max value by calculating first without the first index then without the last index

        return Math.max(robmoney(temp1),robmoney(temp2));
        
    }
    public static int robmoney(int[] arr)
    {
        int n=arr.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    //here we are either going i-1 or i-2 so take 2 pointers prev prev2 and curr for current

    int prev=arr[0];
    int prev2=0;
    int curr=0;
    for(int i=1;i<n;i++)
    {
        
        int take=arr[i];
        if(i>1)
            take+=prev2;
        int nottake=0+prev;

        curr=Math.max(take,nottake);

        prev2=prev;
        prev=curr;
    }
    return prev;

    }
}