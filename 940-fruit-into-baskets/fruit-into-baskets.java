class Solution {
    public int totalFruit(int[] fruits) {
        
    int n = fruits.length;
        // Map fruit → last index seen
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, count = 0;

        while (j < n) {
            // 1) Add/update the last occurrence of fruits[j]
            map.put(fruits[j], j);
            j++;

            // 2) If more than 2 types, evict the one with the smallest last index
            if (map.size() > 2) {
                // find the fruit index to remove
                int minIndex = Collections.min(map.values());
                // remove that fruit type
                map.remove(fruits[minIndex]);
                // shrink window's left boundary
                i = minIndex + 1;
            }

            // 3) Update max window size (j is one past the last valid index)
            count = Math.max(count, j - i);
        }

        return count;
    }
}