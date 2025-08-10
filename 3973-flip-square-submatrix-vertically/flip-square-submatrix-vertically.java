class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
              int sr = x;
        int sc = y;
        int er = sr + k - 1;
        int ec = sc + k - 1;

        // Swap rows within the submatrix vertically
        while (sr < er) {
            for (int c = sc; c <= ec; c++) {
                int temp = grid[sr][c];
                grid[sr][c] = grid[er][c];
                grid[er][c] = temp;
            }
            sr++;
            er--;
        }

        return grid;

        
    }
}