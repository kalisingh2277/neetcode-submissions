class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //similar to jumping frog at naukri platform
        //explore all paths and give the minimum cost
        int n=cost.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        ////dp[0]=cost[0];
        ////dp[1]=cost[1];
        int prev=cost[1];
        int prev2=cost[0];
        int curr=0;
        for(int i=2;i<=n-1;i++)
        {
            
           //// int left=dp[i-1]+cost[i];
           //// int right=dp[i-2]+cost[i];
           int left=prev+cost[i];
           int right=prev2+cost[i];

            ////dp[i]=Math.min(left,right);//tabulation
            curr=Math.min(left,right);

            prev2=prev; //space optimization
            prev=curr;
        }
        // return Math.min(f(n-1,cost,dp),f(n-2,cost,dp));
       //// return Math.min(dp[n-1], dp[n-2]);
       return Math.min(prev,prev2);
    }
    // public static int f(int ind,int[] cost, int[] dp)//recursion
    // {
    //     if(ind==0)
    //         return cost[0];
    //     if(ind==1)
    //         return cost[1];
        
    //     if(dp[ind]!=-1)
    //         return dp[ind];
    //     int left=f(ind-1,cost,dp)+cost[ind];
    //     int right=f(ind-2,cost,dp)+cost[ind];
    //     return dp[ind]=Math.min(left,right);
    // }
}