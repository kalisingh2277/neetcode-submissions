class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> res=new ArrayList<>();
       f(0,nums,res,new ArrayList<>());
       return res; 
    }
    public  static void f(int ind, int nums[], List<List<Integer>> res,ArrayList<Integer> curr)
    {
        if(ind>=nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[ind]);
        f(ind+1,nums,res,curr);
        curr.remove(curr.size()-1);
        f(ind+1,nums,res,curr);

        return;
    }
}
