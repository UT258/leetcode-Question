class Solution {
    public boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();   
     for(int i=0;i<V;i++)
     {
        adj.add(new ArrayList<>());
     }
     for(int arr[]:prerequisites){
        adj.get(arr[1]).add(arr[0]);
     }
     int indeg[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int a:adj.get(i))
            {
                indeg[a]++;
            }
        }
       int topo[]=new int [V];
       Queue<Integer>q=new LinkedList<>();
       for(int i=0;i<V;i++)
       {
           if(indeg[i]==0)
           {
               q.add(i);
           }
       }
       int c=0;
       //if we not able to generate topo array then it has a cycle 
       while(!q.isEmpty())
       {
           int node=q.peek();
           q.remove();
           c++;
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
       return c==V;
        
    }
     
}