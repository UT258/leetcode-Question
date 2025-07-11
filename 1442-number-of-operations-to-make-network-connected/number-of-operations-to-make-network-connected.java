class Solution {
    class Dsu{
        int parent [];
        int rank[];
        public Dsu(int n)
        {
            parent=new int[n+1];
            rank=new int [n+1];
            for(int i=0;i<=n;i++)
            {
                parent[i]=i;//parent of itself
                rank[i]=0;
            }
        }
            public int findUpar(int node)
            {
                //we have to return the ulimate parent
                if(parent[node]==node)
                {
                    return node;
                }
                parent[node]=findUpar(parent[node]);
                return parent[node];
            }
            public void unionbyRank(int u,int v)
            {
                int ulp_u=findUpar(u);
                int ulp_v=findUpar(v);
                if(rank[ulp_u]<rank[ulp_v])
                {
                    //connect smaller to larger
                    parent[ulp_u]=ulp_v;
                    //new parent of the smaller one will the larger one


                }
                else if (rank[ulp_u]>rank[ulp_v])
                {
                    parent[ulp_v]=ulp_u;
                }
                else{
                    //here rank are equal no mattter what you connect
                     parent[ulp_v]=ulp_u;
                     //u->v
                     rank[ulp_u]++;
                    
                }
            }
        }
    
    public int makeConnected(int n, int[][] connections) {
         /*
         to connect two component we need n-1 edges 
         so just find the no of component so to make the whole graph connected 
         we need n-1 edges that will be min 
         */
         if (connections.length < n - 1) {
        // Not enough cables to connect all computers
        return -1;
    }

         Dsu dsu=new Dsu(n);
         int connected=0;
        for(int temp[]:connections)
        {
            //there is a edge between u and v
            int u=temp[0];
            int v=temp[1];
            dsu.unionbyRank(u,v);
        }
        //now to find the no of the component
        for(int i=0;i<n;i++)
        {
            if(dsu.findUpar(i)==i)
            {
                //then its a component
                connected++;
            }
        }
        
        return connected -1;
    }
}