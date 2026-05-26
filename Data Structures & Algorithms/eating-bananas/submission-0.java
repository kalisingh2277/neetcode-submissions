class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxi=0;
        for(int i=0;i<piles.length;i++)
        {
            maxi=Math.max(maxi,piles[i]);
        }
        int ans=0;
        int s=1;
        int e=maxi;
        int mid=s+(e-s)/2;
        while(s<=e)
        {
            long hours=check(piles,mid);
            if(hours>h)
            {
                s=mid+1;
            }
                
            else
            {
                ans=mid;
                e=mid-1;
            }
            mid=s+(e-s)/2;
        }
        return ans;
    }
    public static long check(int num[], int x)
    {
        long sum=0;
        for(int i=0;i<num.length;i++)
        {
            sum=sum+(long)Math.ceil((double)num[i]/x);
        }
        return sum;
    }
}
