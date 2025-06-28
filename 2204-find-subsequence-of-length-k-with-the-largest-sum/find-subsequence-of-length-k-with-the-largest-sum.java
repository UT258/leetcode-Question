class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Pair each number with its index
        List<int[]> indexed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexed.add(new int[]{nums[i], i});
        }

        // Sort by value descending
        indexed.sort((a, b) -> b[0] - a[0]);

        // Take top k largest elements
        List<int[]> topK = indexed.subList(0, k);

        // Sort top k elements by original index to preserve subsequence order
        topK.sort(Comparator.comparingInt(a -> a[1]));

        // Build result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}