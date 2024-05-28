class Solution {

    static class pair {
        int r;
        int c;

        public pair(int r, int c) {
            this.r = r;
            this.c = c;

        }

    }

    // breadth first search
    public static void bfs(int[][] vis, char[][] grid, int r, int c, int[] delrow, int[] delcol) {
        vis[r][c] = 1;// mark the visited and now traverse the neighbours
        // we can go in 4 direction
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(r, c));
        while (!q.isEmpty())

        {
            int row = q.peek().r;
            int col = q.peek().c;
            q.remove();
            // traverse the neighbour
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] == 0
                        && grid[nrow][ncol] == '1') {
                    // if it is not visited and it is land
                    // mark it visted
                    vis[nrow][ncol] = 1;
                    q.add(new pair(nrow, ncol));

                }
            }
        }

    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int vis[][] = new int[r][c];
        int count = 0;
        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, 0, -1 };
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // take every node and start the traversal nd count the traversals
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(vis, grid, i, j, delrow, delcol);

                }
            }
        }

        return count;

    }

}