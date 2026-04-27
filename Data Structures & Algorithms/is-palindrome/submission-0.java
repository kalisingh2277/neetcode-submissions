class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') ||(s.charAt(i)>='a' && s.charAt(i)<='z' )||(s.charAt(i)>='0' && s.charAt(i)<='9') )
            {
            char c=Character.toLowerCase(s.charAt(i));
                res.append(c);
            }
        }
        if(isPalin(res))
            return true;
        return false;
    }
    public static boolean isPalin(StringBuilder res)
    {
        int start=0;
        int end=res.length()-1;
        while(start<=end)
        {
            if(res.charAt(start)!=res.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}