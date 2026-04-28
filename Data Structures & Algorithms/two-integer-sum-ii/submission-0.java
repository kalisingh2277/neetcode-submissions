class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ind[]=new int[2];
        Arrays.fill(ind,-1);

        int s=0;
        int e=numbers.length-1;
        int mid=0;
        while(s<=e)
        {
            int sum=numbers[s]+numbers[e];
            if(sum>target)
            {
                e--;
            }
            else if(sum<target)
            {
                s++;
            }
            else
            {
                ind[0]=s+1;
                ind[1]=e+1;
                break;
            }
        }
        return ind;
    }
}