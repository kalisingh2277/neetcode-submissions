class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)
        {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
           while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1)
            {
                list.add(nums[dq.peekFirst()]);
            }

        }
        int a[]=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            a[i]=list.get(i);
        }
        return a;
    }

}
