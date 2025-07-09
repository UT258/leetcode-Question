class Solution {
    private void dfs(ArrayList<ArrayList<Integer>>adj,boolean vis[],int i)
    {
        vis[i]=true;//mark it visited
        //go to neighbours
        for(Integer n:adj.get(i))
        {
            if(!vis[n])
            {
                dfs(adj,vis,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
      
     //create a adjacency list
     ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
     int v=isConnected.length;

     for(int i=0;i<v;i++)
     {
      adj.add(new ArrayList<>());//since you cannot add anything to null 
     }
     //conver adj matrix to list
     for(int i=0;i<v;i++)
     {

        for(int j=0;j<v;j++)
        {
            //since undirected  there will 
            if(isConnected[i][j]==1 && i!=j){
                //if it is 1 then there is edge between 0 and 1
                adj.get(i).add(j);
                adj.get(j).add(i);
                
            }
        }
     }
     //now we have the adj list
     boolean vis[]=new boolean [v];
     int c=0;

     for(int i =0;i<v;i++)
     {
         if(!vis[i])
         {
            dfs(adj,vis,i);
            c++;
         }
     }
     return c;
    }
}