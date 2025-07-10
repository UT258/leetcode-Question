class Solution {
    public boolean dfs(char[][] board, boolean vis[][], String word, int i, int j, int ind, int m, int n) {
        if (ind == word.length()) {
            //reached the last word return true;
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || board[i][j] != word.charAt(ind)) {
            return false;
        }
        vis[i][j] = true;
        //now go to neighbour
        int dr[] = { -1, 1, 0, 0 }; // row offsets
        int dc[] = { 0, 0, -1, 1 }; // column offsets

        for (int k = 0; k < 4; k++) {
            int nr = dr[k] + i;
            int nc = dc[k] + j;

            //if it is in the range and is equal 
            if (dfs(board, vis, word, nr, nc, ind + 1, m, n))
                return true;

        }
        vis[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean vis[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, vis, word, i, j, 0, m, n))
                    return true;
            }
        }
        return false;
    }
}