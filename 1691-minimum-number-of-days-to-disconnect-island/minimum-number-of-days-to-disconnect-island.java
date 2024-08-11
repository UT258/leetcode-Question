class Solution {
    private final int[][] directions = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 } };
    private int m;
    private int n;

    public int minDays(int[][] grid) {
        // you need to find there are only three possiblity 0 1,2
        // you
        m = grid.length;
        n = grid[0].length;
        int island = numOfIsland(grid);
        if (island > 1 || island == 0) {
            return 0; // it will take 0 days to disconnect

        }
        // if it is not it can be 1 or 2
        // to check if it is one for everylanad
        else {

            // now check for everycel

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // if it is land then conver it into water and check the number of island
                        grid[i][j]=0;
                        island = numOfIsland(grid);
                        // now after this make undo the change
                        grid[i][j] = 1;// make it land again
                        if (island > 1 || island == 0) {
                            return 1;// it can be done in two days
                        }
                    }
                }
            }
        }
        return 2; // if none of this work means it will surely be disconected in two days

    }

    private void dfs(int i, int j, int[][] grid, boolean[][]vis)

    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0)
            return;
        vis[i][j] = true;// mark it visited
        for (int arr[] : directions) {
            int nrow = i + arr[0];
            int ncol = j + arr[1];
            // perform dfs
            dfs(nrow, ncol, grid, vis);// check for all four direction
        }
    }

    private int numOfIsland(int grid[][]) {
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    // if it is land and not visited
                    dfs(i, j, grid, vis);
                    count++;

                }
            }
        }
        return count;

    }
}