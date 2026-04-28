class Solution {
    public int maxArea(int[] heights) {
        int start=0;
        int end=heights.length-1;
        int maxarea=Integer.MIN_VALUE;
        while(start<=end)
        {
           if(heights[start]<heights[end])
           {
             maxarea=Math.max(maxarea,heights[start]*(end-start));
             start++;
           }
           else{
            maxarea=Math.max(maxarea,heights[end]*(end-start));
             end--;
           }

        }
        return maxarea;
    }
}
