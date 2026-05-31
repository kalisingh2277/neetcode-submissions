class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        check(s,list,new ArrayList<>(),0);
        return list;
    }

    public static void check(String s, List<List<String>> list,List<String> current_set,int ind)
    {
        if(ind==s.length())
        {
            list.add(new ArrayList<>(current_set));
            return;
        }
        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                current_set.add(s.substring(ind,i+1));
                check(s,list,current_set,i+1);
                current_set.remove(current_set.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start,int end)
    {
        if(start<0 || end>=s.length() || s==null)
            return false;
        while(start<end)
        {
            if( s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
            
        }
        return true;

    }
}