class Solution {

    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String str:strs)
        {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> result=new ArrayList<>();
        int i=0;
        while(i<str.length())
        {
            int j=i;
            while(str.charAt(j)!='#')
            {
                j++;
            }
            int len=Integer.parseInt(str.substring(i,j));
            String curr=str.substring(j+1,j+len+1);
            result.add(curr);
            i=j+len+1;
        }
        return result;
    }
}
