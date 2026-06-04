class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list=new ArrayList<>();
        if(strs.length==0)
            return list;
        int s=0;
        int end=0;
        boolean visited[]=new boolean[strs.length];
        for(int i=0;i<strs.length;i++)
        {
            s=i;
            if(visited[i]!=true)
            {
                visited[i]=true;
                end=s;
                List<String> curr=new ArrayList<>();
                while(end<strs.length)
                {
                    if(isValid(strs[i],strs[end]))
                    {
                        curr.add(strs[end]);
                        visited[end]=true;
                    }
                    end++;
                }
                list.add(new ArrayList<>(curr));
            }
        }
    return list;
    }
    public static boolean isValid(String s1,String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        int count[]=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int c:count)
        {
            if(c!=0)
                return false;
        }
        return true;
    }
}