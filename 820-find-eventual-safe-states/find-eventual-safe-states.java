class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
          adj.add(new ArrayList<>());
        }
        //instead of indeg create outgoing edges
        
        for (int i = 0; i < V; i++) {
            for (int j : graph[i]) {
                adj.get(j).add(i); // Reverse the edge
            }
        }

        int indeg[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int a:adj.get(i))
            {
                indeg[a]++;
            }
        }
       ArrayList<Integer>topo=new ArrayList<>();
       Queue<Integer>q=new LinkedList<>();
       for(int i=0;i<V;i++)
       {
           if(indeg[i]==0)
           {
               q.add(i);
           }
       }
       
       //if we not able to generate topo array then it has a cycle 
       while(!q.isEmpty())
       {
           int node=q.peek();
           q.remove();
           topo.add(node);
           //go to adjacent nodes
           for(int n:adj.get(node))
           {
               //decrease the ideg of the adj nodes
               indeg[n]--;
               if(indeg[n]==0)
               {
                   //if indege is zero add in the  queue
                   q.add(n);
               }
           }
       }
        Collections.sort(topo);
       return topo;
        
    }
}