class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        generate(nums,list,new ArrayList<>(),freq);
        return list;
    }
    public static void generate(int arr[],List<List<Integer>> list, List<Integer> current_set,boolean freq[])
    {
        if(current_set.size()==arr.length)
        {
            list.add(new ArrayList<>(current_set));
            return;
        }

        for(int i=0;i<arr.length;i++ )
        {
            if(freq[i]!=true)
            {
                freq[i]=true;
                current_set.add(arr[i]);
                generate(arr,list,current_set,freq);
                current_set.remove(current_set.size()-1);
                freq[i]=false;
            }
        }
    }
}
