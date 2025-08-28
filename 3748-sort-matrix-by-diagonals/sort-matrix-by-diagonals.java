import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Ascending diagonals (start from first row)
        for (int i = 1; i < n; i++) {
            int row = 0, col = i;
            int len = Math.min(m, n - i);
            int[] diag = new int[len];

            for (int k = 0; k < len; k++) {
                diag[k] = grid[row++][col++];
            }

            Arrays.sort(diag); // faster than Collections.sort

            row = 0;
            col = i;
            for (int k = 0; k < len; k++) {
                grid[row++][col++] = diag[k];
            }
        }

        // Descending diagonals (start from first col)
        for (int i = 0; i < m; i++) {
            int row = i, col = 0;
            int len = Math.min(n, m - i);
            int[] diag = new int[len];

            for (int k = 0; k < len; k++) {
                diag[k] = grid[row++][col++];
            }

            Arrays.sort(diag);
            // Reverse in place for descending order
            for (int k = 0; k < len / 2; k++) {
                int tmp = diag[k];
                diag[k] = diag[len - 1 - k];
                diag[len - 1 - k] = tmp;
            }

            row = i;
            col = 0;
            for (int k = 0; k < len; k++) {
                grid[row++][col++] = diag[k];
            }
        }

        return grid;
    }
}
