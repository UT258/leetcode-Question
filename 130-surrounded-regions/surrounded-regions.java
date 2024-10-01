class Solution {
    // Directions for moving up, right, down, and left
    private int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public void dfs(int i, int j, boolean[][] vis, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Boundary check
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        
        // If already visited or not 'O', return
        if (vis[i][j] || board[i][j] != 'O') {
            return;
        }
        
        // Mark the cell as visited
        vis[i][j] = true;
        
        // Explore all four directions
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(newRow, newCol, vis, board);
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        
        // Traverse the first and last row
        for (int j = 0; j < n; j++) {
            // First row
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(0, j, vis, board);
            }
            // Last row
            if (!vis[m-1][j] && board[m-1][j] == 'O') {
                dfs(m-1, j, vis, board);
            }
        }
        
        // Traverse the first and last column
        for (int i = 0; i < m; i++) {
            // First column
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }
            // Last column
            if (!vis[i][n-1] && board[i][n-1] == 'O') {
                dfs(i, n-1, vis, board);
            }
        }
        
        // After DFS, flip all unvisited 'O's to 'X's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
