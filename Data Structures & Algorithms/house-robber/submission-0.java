class Solution {
    public int rob(int[] nums) {
    //     //using recursion tc 2^n sc nxn

    //     int n=nums.length;
    //     return f(n-1,nums);
    // }
    // public static int f(int ind, int[] nums)
    // {
    //     if(ind==0)
    //         return nums[0];
    //     if(ind<0)
    //         return 0;
    //     int pick=nums[ind]+f(ind-2,nums);
    //     int not_pick=0+f(ind-1,nums);
    //     return Math.max(pick,not_pick);//giving tle

    //lets optimize it to memoization tc n sc n
    // int n=nums.length;
    // int dp[]=new int[n];
    // Arrays.fill(dp,-1);
    // return f(n-1,nums,dp);
    // }
    // public static int f(int ind, int[] nums,int dp[])
    // {
    //     if(ind==0)
    //         return nums[0];
    //     if(ind<0)
    //         return 0;
    //     if(dp[ind]!=-1)
    //         return dp[ind];
    //     int pick=nums[ind]+f(ind-2,nums,dp);
    //     int not_pick=0+f(ind-1,nums,dp);
    //     return dp[ind]=Math.max(pick,not_pick);
   
//now lets do it using tabulation tc n sc n

    // int n=nums.length;
    // int dp[]=new int[n];
    // Arrays.fill(dp,-1);
    // dp[0]=nums[0];

    // for(int i=1;i<n;i++)
    // {
    //     //int take=nums[ind]+dp[ind-2];//this will thrw error for ind-2 gives negative index
    //     int take=nums[i];
    //     if(i>1)
    //         take+=dp[i-2];
    //     int nottake=0+dp[i-1];

    //     dp[i]=Math.max(take,nottake);
    // }
    // return dp[n-1];

// now lets do space optimization

int n=nums.length;
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    //here we are either going i-1 or i-2 so take 2 pointers prev prev2 and curr for current

    int prev=nums[0];
    int prev2=0;
    int curr=0;
    for(int i=1;i<n;i++)
    {
        
        int take=nums[i];
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