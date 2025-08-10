class Solution {
    int totalLand = 0;
    int boundaryLand = 0;
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    private void dfs(int i, int j, int[][] grid) {
        grid[i][j] = 0; // mark visited
        boundaryLand++; // count this land cell

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length 
                && grid[nr][nc] == 1) {
                dfs(nr, nc, grid);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Count total land first
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) totalLand++;
            }
        }

        // DFS from boundaries to remove connected lands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) 
                    && grid[i][j] == 1) {
                    dfs(i, j, grid);
                }
            }
        }

        return totalLand - boundaryLand;
    }
}
