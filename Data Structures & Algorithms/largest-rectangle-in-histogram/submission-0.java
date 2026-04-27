class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int nse;
        int pse;
        int max_area=Integer.MIN_VALUE;
        int ele;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[i]<heights[st.peek()])
            {
                ele=st.peek();
                st.pop();
                nse=i;
                pse=st.isEmpty()?-1:st.peek();
                max_area=Math.max(max_area,(heights[ele]*(nse-pse-1)));
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            ele=st.peek();
                st.pop();
                nse=n;
                pse=st.isEmpty()?-1:st.peek();
                max_area=Math.max(max_area,(heights[ele]*(nse-pse-1)));
        }
        return max_area;
    }
}