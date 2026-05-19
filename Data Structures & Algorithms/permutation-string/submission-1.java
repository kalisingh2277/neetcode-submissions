class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            freq[s1.charAt(i)-'a']++;
        }
        int window_size=s1.length();
        for(int i=0;i<=s2.length()-window_size;i++)
        {

            int idx=i;
            int freq1[]=new int[26];
            int window=1;
            while(window<=window_size && idx<s2.length())
            {
                freq1[s2.charAt(idx)-'a']++;
                window++;
                idx++;
            }
            if(isSame(freq,freq1))
            {
                return true;
            }

        }
        return false;
    }
    static boolean isSame(int freq[],int freq1[])
    {
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=freq1[i])
                return false;
            
        }
        return true;
    }
}
