class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //left
                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        c++;
                    }
                    //right
                    if (j + 1 == n || grid[i][j + 1] == 0) {
                        c++;
                    }
                    //top
                    if (i - 1 < 0 || grid[i - 1][j] == 0) {
                        c++;
                    }
                    //down
                    if (i + 1 == m || grid[i + 1][j] == 0) {
                        c++;
                    }
                }
            }

        }
        return c;

    }
}