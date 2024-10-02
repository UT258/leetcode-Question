class Solution {
    public void dfs(int i, ArrayList<ArrayList<Integer>>adj,boolean []vis)

    {
        vis[i]=true;// mark it vis 
        for(Integer node:adj.get(i))

        {
            if (!vis[node])
            {
                dfs(node,adj,vis);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //create a adjaceny list
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        
        for(int i=0;i<n;i++)

        {
            list.add(new ArrayList<>());
        }

        for (int arr[]:edges)
        {
            list.get(arr[0]).add(arr[1]);
              list.get(arr[1]).add(arr[0]);
        }
        boolean vis[]=new boolean[n];
           dfs(source,list,vis);
        //if after dfs if there is path to the destinaton it had been marked
       return vis[destination];
    }
}