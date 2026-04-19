class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int arr[]=new int[temperatures.length];
        arr[temperatures.length-1]=0;
        st.push(temperatures.length-1);

        for(int i=temperatures.length-2;i>=0;i--)
        {
            if(temperatures[st.peek()]>temperatures[i])
            {
                arr[i]=st.peek()-i;
                
                
            }
            else
            {
                while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    arr[i]=0;
                }
                else
                {
                    arr[i]=st.peek()-i;
                }
                
                

            }
            st.push(i);
        }
        return arr;
    }
}
