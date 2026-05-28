class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        check(candidates,list,new ArrayList<>(),target,0);
        return list;
    }

    public static void check(int[] arr,List<List<Integer>> list,List<Integer> current_cand,int x ,int ind)
    {
        if(ind>=arr.length)
        {
            if(x==0)
                list.add(new ArrayList<>(current_cand));
            return;
        }

        //pick
        if(arr[ind]<=x) //if current element is greater than the target then no use to add it
        {
            current_cand.add(arr[ind]);
            check(arr,list,current_cand,x-arr[ind],ind);
            //remove the added eleement
            current_cand.remove(current_cand.size()-1);
        }

        //not pick
        check(arr,list,current_cand,x,ind+1);

        return;
        
    }
}