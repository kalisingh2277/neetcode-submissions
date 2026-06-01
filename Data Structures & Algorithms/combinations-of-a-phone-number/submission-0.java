class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()<=0 || digits==null)
            return list;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        generate(digits,list,new StringBuilder(),map,0);
        return list;
    }
    public static void generate(String digits,List<String> list,StringBuilder res,String map[],int ind)
    {
        if(ind>=digits.length())
        {
            list.add((new StringBuilder(res)).toString());
            return;
        }
        int number=digits.charAt(ind)-'0';
        String value=map[number];
        for(int i=0;i<value.length();i++)
        {
            res.append(value.charAt(i));
            generate(digits,list,res,map,ind+1);
            res.deleteCharAt(res.length()-1);

        }
    }
}