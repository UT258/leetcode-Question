class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // base case: reached end of board
        if (row == 9) return true;

        // if reached end of column, go to next row
        if (col == 9) return solve(board, row + 1, 0);

        // if already filled, move to next column
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        // try putting digits 1-9
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;

                if (solve(board, row, col + 1)) return true;

                // backtrack
                board[row][col] = '.';
            }
        }

        // if no number works, return false
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // row check
            if (board[i][col] == c) return false; // col check
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false; // box check
        }
        return true;
    }
}
