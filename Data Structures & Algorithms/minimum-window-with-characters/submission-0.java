class Solution {
    public String minWindow(String s, String t) {
        int freq[]=new int[128];
        int len_t=t.length();
        for(int i=0;i<len_t;i++)
        {
            freq[t.charAt(i)]++;
        }
        int start_index=-1;
        int min_len=Integer.MAX_VALUE;
        int count=0;
        int l=0;
        int r=0;
        while(r<s.length())
        {
            if(freq[s.charAt(r)]>0)
                count++;
            freq[s.charAt(r)]--;
            while(count==len_t)
            {
                if(r-l+1<min_len)
                {
                    min_len=r-l+1;
                    start_index=l;
                }
                
                freq[s.charAt(l)]++;
                if(freq[s.charAt(l)]>0)
                    count--;
                l++;
            }
            r++;
                
        }
        return start_index==-1?"":s.substring(start_index,start_index+min_len);
    }
}
