class Solution {
     private void dfs(int[][] stones, int index, boolean[] visited) {
        visited[index] = true;
        
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i] &&
                (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, i, visited);
            }
        }
    }
    
        public int removeStones(int[][] stones) {
        int n=stones.length;
        int group=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {   if(!vis[i]){
            dfs(stones,i,vis);
            group++;
        }
        }
        return n-group;
    }
}