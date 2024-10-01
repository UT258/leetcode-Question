class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Check if there are enough connections
        if(connections.length < n - 1){
            return -1;
        }
        
        DisjointSet dsu = new DisjointSet(n);
        for(int[] connection : connections){
            dsu.unionBySize(connection[0], connection[1]);
        }
        
        // The number of operations needed is the number of connected components minus one
        return dsu.getCount() - 1;
    }
}

class DisjointSet {
    private int[] parent;
    private int[] size;
    private int count; // Number of connected components

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        count = n; // Initially, each node is its own component
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUltimateParent(int node){
        if(parent[node] != node){
            parent[node] = findUltimateParent(parent[node]); // Path compression
        }
        return parent[node];
    }

    public void unionBySize(int u, int v){
        int ultU = findUltimateParent(u);
        int ultV = findUltimateParent(v);
        
        if(ultU == ultV){
            // Already in the same component, this is a redundant connection
            return;
        }
        
        // Union by size
        if(size[ultU] < size[ultV]){
            parent[ultU] = ultV;
            size[ultV] += size[ultU];
        }
        else{
            parent[ultV] = ultU;
            size[ultU] += size[ultV];
        }
        
        count--; // After union, the number of components decreases by one
    }

    public int getCount(){
        return count;
    }
}
