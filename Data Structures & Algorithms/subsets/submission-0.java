class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int ind=0;
        List<List<Integer>> list=new ArrayList<>();
        calculate(nums,list,new ArrayList<>(),0);
        return list;
    }
    public static List<List<Integer>> calculate(int[] nums,List<List<Integer>> list,ArrayList<Integer> current_subset,int ind )
    {
        if(ind>=nums.length)
        {
            list.add(new ArrayList<>(current_subset));
            return list;
        }
        
        current_subset.add(nums[ind]);
        calculate( nums,list,current_subset,ind+1 );
        current_subset.remove(current_subset.size()-1);
        calculate(nums,list,current_subset,ind+1);
    return list;
    }
}
