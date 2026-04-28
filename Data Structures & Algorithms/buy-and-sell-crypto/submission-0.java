class Solution {
    public int maxProfit(int[] prices) {
        // Stack<Integer> st=new Stack<>();
        // st.push(prices[prices.length-1]);
        // int max_profit=0;
        // for(int i=prices.length-2;i>=0;i--)
        // {
        //     if(st.peek()>prices[i])
        //     {
        //         max_profit=Math.max(max_profit,st.peek()-prices[i]);
        //     }
        //     else
        //     {
        //         st.push(prices[i]);
        //     }
        // }
        // return max_profit;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
           
            if (price < minPrice) {
                minPrice = price;
            }
            
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}