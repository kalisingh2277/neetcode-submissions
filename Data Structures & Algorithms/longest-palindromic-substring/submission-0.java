class Solution {
    public String longestPalindrome(String s) {
        //this was recursion plus dp
    //     if (s == null || s.length() == 0)
    //         return "";
    //     int maxdata[]=new int[2];
    //     maxdata[0]=1;
    //     maxdata[1]=0;
    //     int n=s.length();
    //     int dp[][]=new int[n][n];
    //     for(int row[]:dp)
    //     {
    //         Arrays.fill(row,-1);
    //     }
    //     int ind1=0;
    //     int ind2=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         for(int j=0;j<n;j++)
    //         {
    //             dp[i][j]=1;
    //         }
    //     }
    //     f(0,n-1,s,maxdata,dp);
    //     return s.substring(maxdata[1],maxdata[1]+maxdata[0]);

    // }
    // public static int f(int ind1,int ind2, String s, int maxdata[],int dp[][])
    // {
    //     if(ind1>ind2)
    //         return 0;
    //     if(ind1==ind2)
    //         return 1;
    //     if (dp[ind1][ind2]!=-1)
    //         return dp[ind1][ind2];
    //     if(isPalin(s.substring(ind1,ind2+1)))
    //     {
    //         int currlen=ind2-ind1+1;
    //         if(currlen>maxdata[0])
    //         {
    //             maxdata[0]=currlen;
    //             maxdata[1]=ind1;
    //         }
    //         return currlen;
            
    //     }
    //     int left=f(ind1+1,ind2,s,maxdata,dp);
    //     int right=f(ind1,ind2-1,s,maxdata,dp);
    //     return dp[ind1][ind2]=Math.max(left,right);
    // }
    // public static boolean isPalin(String s )
    // {
    //     int start=0;
    //     int end=s.length()-1;
    //     while(start<=end)
    //     {
    //         if(s.charAt(start)!=s.charAt(end))
    //             return false;
    //         start++;
    //         end--;
    //     }
    //     return true;


    //solving it by revrsing the string and applying the longest common subsequence
    StringBuilder rev=new StringBuilder(s);
    rev=rev.reverse();
    return f(s,rev.toString());

    }
    public static String f(String s1, String s2)
    {
        int n=s1.length();
        int m=s2.length();
        // int dp[][]=new int[n+1][m+1];

        int prev[]=new int[m+1];
        

        // for(int rows[]:dp)
        // {
        //     Arrays.fill(rows,0);
        // }
        int arr[]=new int[2];//0 index for max len, 1st index for i track 
        for(int i=1;i<=n;i++)
        {
            int curr[]=new int[m+1];
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    //dp[i][j]=1+dp[i-1][j-1];
                    curr[j]=1+prev[j-1];
                    // if(dp[i][j]>arr[0] && (i-dp[i][j]==n-j))
                    if(curr[j]>arr[0] && (i-curr[j]==n-j))
                    {
                        // arr[0]=dp[i][j];
                        arr[0]=curr[j];
                        arr[1]=i-1;
                    }
                    
                }
                else
                {
                    // dp[i][j]=0;
                    curr[j]=0;
                }
            }
            prev=curr;
        }

        int maxlen=arr[0];
        int end_ind=arr[1];//in original string
        int start_ind=end_ind-maxlen+1;
        return s1.substring(start_ind,end_ind+1);

    }
}