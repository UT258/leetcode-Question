class Solution {
    public int makeConnected(int n, int[][] connections) {
          if(connections.length < n - 1){
            return -1;
        }
        
        DisjointSet d=new DisjointSet(n);
        for(int arr[]:connections)
        {
            d.unionBysize(arr[0],arr[1]);
        }
        //count the connected components
        // if there are n component to connect them n-1 operation will be needed 
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(d.ultimateParent(i)==i)
            {
                count++;
            }
        }
        return count-1;
        
    }
}
public class DisjointSet {

    ArrayList<Integer>rank=new ArrayList<>();
    ArrayList<Integer>parent=new ArrayList<>();
    ArrayList<Integer>size=new ArrayList<>();


    public DisjointSet(int n) {
        //mark all the parent with itself when there is no addtion
        for (int i = 0; i <=n ; i++) {
            rank.add(0);
            parent.add(i);//cuz they are the super parent of each other
            size.add(1);//size is one for all the nodes

        }
    }
    public int ultimateParent(int node)
    {
     //we will use path compression using recursion
        if(parent.get(node)==node)
        {
            //if the parent is equal to itself we found the node that is common ultimate parent
            return node;
        }
        //now here path compression takes place
        int ult=ultimateParent(parent.get(node));//find the parent for all the nodes
        parent.set(node,ult);//when return the node will be the parent for all the nodes
        return parent.get(node);

    }
    public void UnionByRank(int u,int v){
        int ultimateU=ultimateParent(u);
        int ultimateV=ultimateParent(v);
        if(rank.get(ultimateU)< rank.get(ultimateV))
        {
            //if u is lesser then connect the smaller to greater
            //so there will be no  change in the rank
            parent.set(ultimateU,ultimateV);
        }
        else if(rank.get(ultimateV)<rank.get(ultimateU))
        {   //smaller guy connected to greater guy
            parent.set(ultimateV,ultimateU);
        }
        else{
            //means both are equal
            parent.set(ultimateV,ultimateU);
            rank.set(ultimateU,rank.get(ultimateU)+1 );
            //increase the rank
        }

    }
    //find union by size
    public void unionBysize(int u,int v){
        int ult_u=ultimateParent(u);
        int ult_v=ultimateParent(v);
        if (ult_v==ult_u)
        {
            return;

        }
        if(size.get(ult_v)<size.get(ult_u))
        {
            parent.set(ult_v,ult_u);
            size.set(ult_v, size.get(u)+size.get(v) );
        }
        if(size.get(ult_u)<size.get(ult_v))
        {
            parent.set(ult_u,ult_v);
             size.set(ult_u, size.get(v)+size.get(u) );
        }
        else{
            parent.set(ult_u,ult_v);
            size.set(ult_u, size.get(u)+size.get(v) );
        }
    }
}