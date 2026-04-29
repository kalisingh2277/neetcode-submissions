class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[256];
        int max=0;
        int l=0;
        int r=0;
        Arrays.fill(hash,-1);
        while(r<s.length())
        {
            if(hash[s.charAt(r)]!=-1)
            {
                if(hash[s.charAt(r)]>=l)
                {
                    l=hash[s.charAt(r)]+1;
                }
            }
            hash[s.charAt(r)]=r;
            max=Integer.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
