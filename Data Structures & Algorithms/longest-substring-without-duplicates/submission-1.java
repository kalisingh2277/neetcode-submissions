class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[256];
        Arrays.fill(hash,-1);

        int l=0;
        int r=0;
        int max_len=0;

        while(r<s.length())
        {
            if(hash[s.charAt(r)]!=-1)
            {
                //now check wheter it is there in the window or not
                if(hash[s.charAt(r)]>=l)//it mean same character is their inside the window so shrink the window by 1
                {
                    l=hash[s.charAt(r)]+1;
                }

            }
            hash[s.charAt(r)]=r;
            max_len=Math.max(max_len,r-l+1);
            r++;
        }
        return max_len;
    }
}
