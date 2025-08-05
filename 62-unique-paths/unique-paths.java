class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int [m][n];
         dp[0][0]=1;//base case 
         for(int i=0;i<m;i++)
         {
            for(int j=0;j<n;j++)
            {
                if (i==0 && j==0) continue;
                int left=0;
                int up=0;
                if(j>0) left+=dp[i][j-1];
                if(i>0) up+=dp[i-1][j];
                dp[i][j]=left+up;
            }
         }
         return dp[m-1][n-1];
        
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