class Solution {
    // Class to represent a cell in the grid
    class Pair {
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // If the starting or ending cell is blocked, return -1
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // If the grid is a single cell and it's clear
        if (n == 1) {
            return 1;
        }

        // Directions for 8 possible movements (including diagonals)
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        // Initialize a visited matrix
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // Initialize the BFS queue
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 1)); // Starting at (0,0) with distance 1

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int r = current.row;
            int c = current.col;
            int dist = current.dist;

            // Explore all 8 directions
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // Check if we've reached the destination
                if (nr == n - 1 && nc == n - 1 && grid[nr][nc] == 0) {
                    return dist + 1;
                }

                // Check boundaries, cell is clear, and not visited
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Pair(nr, nc, dist + 1));
                }
            }
        }

        // If the destination is not reachable
        return -1;
    }
}