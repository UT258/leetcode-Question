class Solution {
    public int coinChange(int[] coins, int amount) {
        final int max=Integer.MAX_VALUE-1; //-1 so that overflow when i add 1
        int n=coins.length;
        int dp[][]=new int [n+1][amount+1];
        //fill the base case first 
        for(int i=0;i<=amount;i++)
        {
            dp[0][i]=max; //how many sum you can form when  you have 0 element
            //infinity
            
        }
        for(int i=0;i<=coins.length;i++)
        {
            dp[i][0]=0; //how many coins you need to form 0 
            
        }
         for(int i=1;i<=coins.length;i++){
          for (int j=1;j<=amount;j++){
              if(coins[i-1]<=j)
              {  //take and no take case
                  int take=1+dp[i][j-coins[i-1]];//if i take it since we have unlimited supply when we decide to pick we may pick it again
                  int notake=dp[i-1][j];
               dp[i][j]=Math.min(take,notake);

              }
              else{
                  dp[i][j]=dp[i-1][j];//we cannot take it since it is greater
              }
          }

      }
      int ans=dp[coins.length][amount];
      return  ans==Integer.MAX_VALUE-1?-1:ans;
        
        


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