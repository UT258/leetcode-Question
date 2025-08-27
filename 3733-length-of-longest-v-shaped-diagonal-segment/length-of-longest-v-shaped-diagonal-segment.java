class Solution {
    int m = 0, n = 0;
    int max = 0; // to store longest path
    int[][] dir = {{1,1},{1,-1},{-1,-1},{-1,1}}; // diagonals

    public void dfs(int i, int j, int d, boolean turnUsed, int[][] grid, int expected, int len) {
        // boundary check
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        // sequence check
        if (grid[i][j] != expected) return;

        // update max
        max = Math.max(max, len);

        int nr = i + dir[d][0];
        int nc = j + dir[d][1];
        int nextExpected = (expected == 2 ? 0 : 2);

        // continue straight
        dfs(nr, nc, d, turnUsed, grid, nextExpected, len + 1);

        // try clockwise turn (only if not used yet)
        if (!turnUsed) {
            int newDir = (d + 1) % 4;
            int tr = i + dir[newDir][0];
            int tc = j + dir[newDir][1];
            dfs(tr, tc, newDir, true, grid, nextExpected, len + 1);
        }
    }

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        dfs(i, j, d, false, grid, 1, 1); // start expecting 1
                    }
                }
            }
        }
        return max;
    }
}
