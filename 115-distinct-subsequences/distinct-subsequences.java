class Solution {
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        int dp[][]=new int [m+1][n+1];
        for(int temp[]:dp)
        {
            Arrays.fill(temp,-1);
        }
        return solve(s, t, m, n,dp);

    }

    int solve(String s, String t, int i, int j,int dp[][]) {
        if(j==0)return 1;//always possible to  form the empty
        if(i==0) return 0;

       if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=solve(s,t,i-1,j-1,dp)+solve(s,t,i-1,j,dp);
        }
        return dp[i][j]=solve(s,t,i-1,j,dp);

    }
}