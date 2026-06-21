class Solution {
    public int maxProduct(int[] nums) {
    //     int maxi[]=new int[1];
    //     maxi[0]=Integer.MIN_VALUE;
    //     f(0,nums,maxi);
    //     return maxi[0];
    // }
    // public static void f(int ind, int nums[], int maxi[])
    // {
    //     if(ind==nums.length)
    //         return;
    //     int prod=1;
    //     for(int i=ind;i<nums.length;i++)
    //     {
    //         prod=prod*nums[i];
    //         if(prod>maxi[0])
    //         {
    //             maxi[0]=prod;
    //         }
    //     }
    //     f(ind+1,nums,maxi);

        int suffix=1;
        int prefix=1;
        int max_prod=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(prefix==0)
            {
                prefix=1;
            }
            if(suffix==0)
            {
                suffix=1;
            }
            prefix=prefix*nums[i];
            suffix=suffix*nums[nums.length-i-1];
            max_prod=Math.max(max_prod,Math.max(prefix,suffix));
        }
        return max_prod;
    }
}