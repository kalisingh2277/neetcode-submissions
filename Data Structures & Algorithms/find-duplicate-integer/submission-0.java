class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // int f=0;
        // int n=1;
        // while(n<nums.length)
        // {
        //     if(nums[f]==nums[n])
        //     {
        //         break;
        //     }
        //     n++;
        //     f++;
        // }
        // return nums[f];
        // HashMap<Integer,Integer> hm=new HashMap<>();
        // for(int i=0;i<nums.length;i++)
        // {
        //     hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        // }
        // int ans=0;
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(hm.get(nums[i])>1)
        //     {
        //         ans=nums[i];
        //         break;
        //     }
        // }
        // return ans;



        //CHECK OUT O(1) SPACE SOLUTION


        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(arr[nums[i]-1]==0)
            {
                arr[nums[i]-1]++;
            }
            else
                return nums[i];

        }
        return 0;
    }
}
