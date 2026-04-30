class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int max_l=0;
        int max_f=0;
        int hash[]=new int[26];
        while(r<s.length())
        {
            hash[s.charAt(r)-'A']++;
            max_f=Math.max(max_f,hash[s.charAt(r)-'A']);
            if((r-l+1)-max_f>k)
            {
                hash[s.charAt(l)-'A']--;
                
                l++;
            }
            if((r-l+1)-max_f<=k)
            {
                max_l=Math.max(max_l,r-l+1);
            }
            r++;
        }
        return max_l;

    }
}