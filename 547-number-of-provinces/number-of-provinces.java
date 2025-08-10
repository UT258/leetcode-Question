class Solution {
    private void dfs(int i,boolean vis[],int[][] grid,ArrayList<ArrayList<Integer>>adj)
    {   if(vis[i]) return ;
        vis[i]=true;//mark the node visited
        for(Integer curr:adj.get(i))
        {
            if(!vis[curr])
            {
                dfs(curr,vis,grid,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
       int m=isConnected.length;
       int n=isConnected[0].length;
       //create adjacecy list
       ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
       for(int i=0;i<m;i++)
       {
        adj.add(new ArrayList<>());//to intialize
       }
       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(isConnected[i][j]==1 && i!=j)
            {
                //not consider the self nodes
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
       }

        boolean vis[]=new boolean [m];
        int c=0;
        for(int i=0;i<m;i++)
        {
            if(!vis[i])
            {
                dfs(i,vis,isConnected,adj);
                c++;
            }
        }
        return c;

       
       
    }
}