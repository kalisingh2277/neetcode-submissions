class Solution {
    public int coinChange(int[] coins, int amount) {
    //     int dp[][]=new int[coins.length][amount+1];
    //     for(int rows[]:dp)
    //     {
    //         Arrays.fill(rows,-1);
    //     }
    //     int ans= f(coins.length-1,coins,amount,dp);
    //     if(ans>=(int)1e9)
    //     {
    //         return -1;
    //     }
    //     return ans;
    // }
    // public static int f(int ind,int[] coins, int target,int[][] dp)
    // {
    //     if(ind==0)
    //     {
    //         if(target%coins[ind]==0)
    //         {
    //             return target/coins[ind];
    //         }
    //         else
    //             return (int)1e9;
    //     }
    //     if(dp[ind][target]!=-1)
    //         return dp[ind][target];
    //     int nottake=0+f(ind-1,coins,target,dp);
    //     int take=Integer.MAX_VALUE;
    //     if(coins[ind]<=target)
    //     {
    //         take=1+f(ind,coins,target-coins[ind],dp);
    //     }

    //     return dp[ind][target]=Math.min(take,nottake);


    //tabulation
        // int n=coins.length;
        // int dp[][]=new int[n][amount+1];
        // for(int target=0;target<=amount;target++)
        // {
        //     if(target%coins[0]==0)
        //     {
        //         dp[0][target]=target/coins[0];
        //     }
        //     else
        //         dp[0][target]=(int)1e9;
        // }

        // for(int ind=1;ind<=n-1;ind++)
        // {
        //     for(int target=0;target<=amount;target++)
        //     {
        //         int nottake=0+dp[ind-1][target];
        //         int take=Integer.MAX_VALUE;
        //         if(coins[ind]<=target)
        //         {
        //             take=1+dp[ind][target-coins[ind]];
        //         }
        //         dp[ind][target]=Math.min(take,nottake);
        //     }
        // }
        // int ans= dp[n-1][amount];
        // if(ans>=(int)1e9)
        // {
        //     return -1;
        // }
        // return ans;


        //space optimization

         int n=coins.length;
        int prev[]=new int[amount+1];
        
        for(int target=0;target<=amount;target++)
        {
            if(target%coins[0]==0)
            {
                prev[target]=target/coins[0];
            }
            else
                prev[target]=(int)1e9;
        }

        for(int ind=1;ind<=n-1;ind++)
        {
            int curr[]=new int[amount+1];
            for(int target=0;target<=amount;target++)
            {
                int nottake=0+prev[target];
                int take=Integer.MAX_VALUE;
                if(coins[ind]<=target)
                {
                    take=1+curr[target-coins[ind]];
                }
                curr[target]=Math.min(take,nottake);
            }
            prev=curr;
        }
        int ans= prev[amount];
        if(ans>=(int)1e9)
        {
            return -1;
        }
        return ans;
    }
}