class Solution {
    int c = 0;

    private void dfs(int i, int j, int[][] grid, boolean vis[][], int[] dr, int[] dc)

    {
        vis[i][j] = true;
        
        //go to negbour
        for (int k = 0; k< 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !vis[nr][nc] && grid[nr][nc]==1) {
                dfs(nr, nc, grid, vis, dr, dc);
            }
        }

    }

    public int numEnclaves(int[][] grid) {
        
    //start from boundary and connect 
       int m=grid.length;
       int n=grid[0].length;
       boolean vis[][]=new boolean [m][n];
       int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
           if(i==0 || j==0 || i==m-1 ||j==n-1 )
           {  if(!vis[i][j] && grid[i][j]==1)
             dfs(i,j,grid,vis,dx,dy);
                
           }
           
           
        }

       }
       int c=0;
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
           if(grid[i][j]==1 && !vis[i][j])
           {
            c++;
           }
           
           
        }

       }

       return c;
    }
}