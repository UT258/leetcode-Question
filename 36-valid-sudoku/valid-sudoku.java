class Solution {
    private boolean valid(int sr, int sc, int er, int ec, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        //check all the rows
        //and check all the cols 
        //check for rows
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue; //no need to check
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);//just add normally
            }
        }
        //check for columns
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue; //no need to check
                if (set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);//just add normally
            }
        }

        //check for individual matrix
        for (int sr = 0; sr < 9; sr += 3) {
            int er = sr + 2;
            for (int sc = 0; sc < 9; sc += 3) {
                int ec = sc + 2;
                if (!valid(sr, sc, er, ec, board)) {
                    return false;
                }
            }
        }
        return true;//none of the condition matched so it is valid
    }
}