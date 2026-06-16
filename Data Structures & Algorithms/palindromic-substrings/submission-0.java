class Solution {
    public int countSubstrings(String s) {
    //     return f(0,s);
    // }
    // public static int f(int ind,String s)
    // {
    //     if(ind==s.length())
    //         return 0;
        
    //     int count=0;
    //     for(int i=ind;i<s.length();i++)
    //     {
    //         if(isPalin(ind,i,s))
    //             count++;
    //     }
    //     return count+f(ind+1,s);
    // }
    // public static boolean isPalin(int start,int end,String s)
    // {
    //     while(start<=end)
    //     {
    //         if(s.charAt(start)!=s.charAt(end))
    //             return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    int n=s.length();
    int count=0;
    for(int i=0;i<n;i++)
    {
        int l=i;
        int r=i;
        while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
        {
            count++;
            l--;
            r++;
        }

        l=i;
        r=i+1;

        while(l>=0 && r<n && s.charAt(l)==s.charAt(r))
        {
            count++;
            l--;
            r++;
        }


    }
    return count;
    }
}