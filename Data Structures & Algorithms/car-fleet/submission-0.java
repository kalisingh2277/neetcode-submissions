class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        Double cars[][]=new Double[n][2];

        for(int i=0;i<n;i++)
        {
            cars[i][0]=(double)position[i];
            cars[i][1]=(double)(target-position[i])/speed[i];
        }

        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));
        Stack<Double> st=new Stack<>();
        int fleet=0;
        for(Double car[]:cars)
        {
            double c_time=car[1];
            while(!st.isEmpty() && st.peek()<c_time)
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                fleet++;
            }
            
                st.push(c_time);

        }
        return fleet;
    }
    
}
