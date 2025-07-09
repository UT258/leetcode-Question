class Solution {

    class Dsu {
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        public Dsu(int n) {
            rank.clear();
            parent.clear();
            for (int i = 0; i <= n; i++) {
                //making in gen graph 0 as well as 1 base index
                rank.add(0);
                parent.add(i);
            }

        }

        public int findUpar(int node) {
            if (node == parent.get(node)) {
                //this is mean we find that is ultimate parent of itself
                return node;
            }
            //path compression
            parent.set(node, findUpar(parent.get(node)));
            return parent.get(node);
        }

        public void unionByrank(int u, int v) {
            int ulp_u = findUpar(u);
            int ulp_v = findUpar(v);
            //connec the smaller one to larger one 
            if (rank.get(ulp_u) < rank.get(ulp_v))

            {
                parent.set(ulp_u, ulp_v);

            }
            if (rank.get(ulp_u) > rank.get(ulp_v))

            {
                parent.set(ulp_v, ulp_u);

            } else {
                //they are equal then rank will increase
                //since rank are equal connecct anyone
                parent.set(ulp_u, ulp_v);
                rank.set(ulp_v, rank.get(ulp_v) + 1);
            }

        }
    }

    public int findCircleNum(int[][] isConnected) {
        // now using the disjoint set
        //create dsu
        int v = isConnected.length;
        Dsu dsu = new Dsu(v);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    //there is a edge between u and v
                    dsu.unionByrank(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i <v; i++) {
            if (dsu.findUpar(i) == i) {
                count++;
            }
        }
        return count;

    }
}