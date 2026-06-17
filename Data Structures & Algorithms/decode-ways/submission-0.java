class Solution {
    public int numDecodings(String s) {
    //     int totalways[]=new int[1];
    //     f(0,s,totalways);
    //     return totalways[0];
    // }
    // public static void f(int ind, String s,int[] totalways)
    // {
    //     if(ind==s.length())
    //     {
    //         totalways[0]++;
    //         return;
    //     }
            
    //     if(s.charAt(ind)=='0')
    //         return;

    //     f(ind+1,s,totalways);
    //     if(ind+1<s.length() && (s.charAt(ind)=='1' || (s.charAt(ind)=='2' && s.charAt(ind+1)>='0' && s.charAt(ind+1)<='6')))
    //     {
    //         f(ind+2,s,totalways);
    //     }

    //     return;

//using memoization

    //     int dp[]=new int[s.length()];
    //     Arrays.fill(dp,0);
    //     return f(0,s,dp);
    // }
    // public static int f(int ind, String s, int dp[])
    // {
    //     if(ind==s.length())
    //     {
    //         return 1;
    //     }
    //     if(s.charAt(ind)=='0')
    //         return 0;
    //     if(dp[ind]!=0)
    //         return dp[ind];
    //     int ways=0;

    //     ways+=f(ind+1,s,dp);

    //      if(ind+1<s.length() && (s.charAt(ind)=='1' || (s.charAt(ind)=='2' && s.charAt(ind+1)>='0' && s.charAt(ind+1)<='6')))
    //     {
    //         ways+=f(ind+2,s,dp);
    //     }

    //     return dp[ind]=ways;



        //now using tabulation format
        // int n=s.length();
        // int dp[]=new int[n+1];
        // dp[n]=1;
        // for(int i=n-1;i>=0;i--)
        // {
        //     if(s.charAt(i)=='0')
        //         dp[i]=0;
        //     else
        //     {
        //         int ways=0;
                
        //         ways+=dp[i+1];
                
        //         if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) {
        //             ways += dp[i + 2];
        //         }
        //         dp[i]=ways;
        //     }
        // }
        // return dp[0];


        //now doing space optimization
        int n=s.length();
        
        int prev1=1;
        int prev2=0;
        for(int i=n-1;i>=0;i--)
        {
            int curr=0;
            if(s.charAt(i)!='0')
            {
                curr+=prev1;

                if(i+1<s.length() && (s.charAt(i)=='1' || (s.charAt(i)=='2' && (s.charAt(i+1)>='0' && s.charAt(i+1)<='6'))))
                {
                    curr+=prev2;

                }
            }
            
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}