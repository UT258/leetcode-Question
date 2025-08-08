class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int digit = board[i][j] - '0' - 1; // 0-based index
                int boxIndex = (i / 3) * 3 + (j / 3); // Map to 3x3 box index (0 to 8)

                if (row[i][digit] || col[j][digit] || box[boxIndex][digit]) {
                    return false;
                }

                row[i][digit] = true;
                col[j][digit] = true;
                box[boxIndex][digit] = true;
            }
        }

        return true;
    }
}
