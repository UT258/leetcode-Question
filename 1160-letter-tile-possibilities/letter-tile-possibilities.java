class Solution {
    int n;

    public int numTilePossibilities(String tiles) {
        n = tiles.length();
        boolean[] used = new boolean[n];
        Set<String> result = new HashSet<>();
        StringBuilder curr = new StringBuilder();

        solve(tiles, used, result, curr);
        return result.size() - 1; // Subtract 1 to exclude the empty sequence
    }

    private void solve(String tiles, boolean[] used, Set<String> result, StringBuilder curr) {
        result.add(curr.toString());

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;

            // Choose the tile at index i
            curr.append(tiles.charAt(i));
            used[i] = true;

            // Explore further with this choice
            solve(tiles, used, result, curr);

            // Backtrack: remove the tile and mark it unused
            used[i] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}