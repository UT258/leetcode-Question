class Solution {
    public void dfs(int i, int j, boolean[][] vis, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Boundary check and mark it visited
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O' || vis[i][j]) {
            return;
        }
        
        vis[i][j] = true;
        
        // Do DFS in four directions
        dfs(i - 1, j, vis, board);
        dfs(i + 1, j, vis, board);
        dfs(i, j - 1, vis, board);
        dfs(i, j + 1, vis, board);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        
        // First and last row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                dfs(0, i, vis, board);
            }
            if (board[m - 1][i] == 'O' && !vis[m - 1][i]) {
                dfs(m - 1, i, vis, board);
            }
        }
        
        // First and last column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, vis, board);
            }
            if (board[i][n - 1] == 'O' && !vis[i][n - 1]) {
                dfs(i, n - 1, vis, board);
            }
        }
        
        // Flip all unvisited 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
