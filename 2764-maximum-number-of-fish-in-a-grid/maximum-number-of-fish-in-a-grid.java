class Solution {
    static int sum;
    public void dfs(int i,int j,boolean vis[][],int[][]grid)
    {
        //mark it visited
        vis[i][j]=true;
        //add in the sum
        sum+=grid[i][j];
        //visit the adjacent nodes
        int r[]={ -1,0,1,0};
        int c[]={0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int dr=i+r[k];
            int dc=j+c[k];
    if (dr>=0 && dr<grid.length &&  dc>=0 && dc<grid[0].length && !vis[dr][dc] && grid[dr][dc]>0)
            {
                //this must be not visited and must be water
                dfs(dr,dc,vis,grid);
            }
        }
    }
    public int findMaxFish(int[][] grid) {
        int ans=Integer.MIN_VALUE;
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum=0;
                if(grid[i][j]>0 && !vis[i][j])
                {
                    dfs(i,j,vis,grid);
                }
                //here calulate the maximum 
                ans=Math.max(ans,sum);

            }

        }
        return ans;
        
    }
}