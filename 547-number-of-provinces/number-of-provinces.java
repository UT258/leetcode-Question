class Solution {
    public static void dfs(boolean vis[], int current,int  grid[][]) {
        if(vis[current])
        {
            return;
        }
        vis[current] = true;
        // find the neighbours

        for (int i=0;i<grid[0].length;i++) {
            if (grid[current][i]==1) {
                dfs(vis, i, grid);
            }
        }
    }

    public int findCircleNum(int[][] isconnected) {
        if(isconnected.length==0)
        {
            return 0;
        }
    
     // now main program 
     boolean vis[]=new boolean[isconnected.length];
     int count=0;
     for(int i=0;i<isconnected.length;i++)
     {
        if(vis[i]==false)
        {
            dfs(vis,i,isconnected);
            count++;
        }
     
     }

    return count;
        
    }
}