class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int [m][n];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }

        return solve(m-1,n-1,dp);
        
    }
    public static int solve(int m,int n,int [][]dp)

    {
        if(m== 0 && n==0)
        {
            //reach the destination
            return 1;
        }
        int left=0;
        int up=0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(n>0)
        {
            left+=solve(m,n-1,dp);
        }
        if(m>0)
        {
            up+=solve(m-1,n,dp);
        }
        return dp[m][n]= left+up;
    }
}