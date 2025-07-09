class Solution {

    class Dsu {
        int[] parent;
        int[] rank;

        public Dsu(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findUpar(int node) {
            if (parent[node] != node) {
                parent[node] = findUpar(parent[node]); // Path compression
            }
            return parent[node];
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUpar(u);
            int ulp_v = findUpar(v);

            if (ulp_u == ulp_v) return; // Already in same set

            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_u] = ulp_v;
                rank[ulp_v]++;
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Dsu dsu = new Dsu(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    dsu.unionByRank(i, j);
                }
            }
        }

        // Count the number of unique parents
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.findUpar(i) == i) {
                count++;
            }
        }

        return count;
    }
}
