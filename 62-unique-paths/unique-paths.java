class Solution {
    public static int solve(int m,int n,int dp[][])
    {
     if(m==0 || n==0)
     {
        return 1;
     }
     if(n<1 || m<1)
     {
        return 0;
     }
     if(dp[m][n]!=-1)
     {
        return dp[m][n];
     }
    
     int top =solve(m,n-1,dp);
     int right=solve(m-1,n,dp);
     dp[m][n]=top+right;
     return    dp[m][n];
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int [m+1][n+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        return solve(m-1,n-1,dp);
    }
}