class Solution {
    public int climbStairs(int n) {
       //bottom up start building soluttion from the base case
       int dp[]=new int [n+1];
       //since this is one based indexing
       Arrays.fill(dp,-1);
     return  solve(n,dp);
        
    }
    public int solve(int n,int dp[])
    {
        if(n<=2)
        {   dp[n]=n;
            return n;
        }
        if(dp[n]!=-1)
        {
            //already have the answer 
            return dp[n];
        }
        dp[n]=solve(n-1,dp)+solve(n-2,dp);
        return dp[n];
    }
}