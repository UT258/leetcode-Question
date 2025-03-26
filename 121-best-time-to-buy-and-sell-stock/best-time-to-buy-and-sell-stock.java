class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        if(prices.length==1)
        {
            return 0;
        }
        int max=Integer.MIN_VALUE;
        //start by considering the first one 
        //buy at lowest price and sell at higher price
        for(int i=1;i<prices.length;i++)
        {
            int sell=prices[i];
            if(buy>sell)
            {
                //then this more minimu price to buy
                buy=sell;
            }
            
                //than i can get some profit
                max=Math.max(max,sell-buy);
            
        }
        return max;
        
    }
}