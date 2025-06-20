class Solution {
    public int coinChange(int[] coins, int amount) {
         int dp[][]=new int[coins.length+1][amount+1];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
         int res = coins(coins, amount, coins.length,dp);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;

    }

    static public int coins(int[] coins, int amount, int n,int [][]dp) {
        if(amount==0)
        {
            return 0;//if amount is 0 then no coins are needed
        }
        if (n == 0) {

            return Integer.MAX_VALUE-1;
        }
        if(dp[n][amount]!=-1)
        {
            return dp[n][amount];
        }
        if(coins[n-1]<=amount)
        {   //if i decide to pick it then there is chance i will pick it again  we wil not reduce the size
            //then i can take it
            return dp[n][amount]=Math.min(1+coins(coins,amount-coins[n-1],n, dp),coins(coins,amount,n-1, dp));

        }
        else{
            return  dp[n][amount]=coins(coins,amount,n-1, dp); //if i dont pick it then i will reduce the size
        }
    }
}