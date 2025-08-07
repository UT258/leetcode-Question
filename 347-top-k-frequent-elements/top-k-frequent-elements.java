class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Arrays.sort(nums); // Step 1: Sort the array

        List<int[]> freqList = new ArrayList<>();
        int start = 0;
        int n = nums.length;

        // Step 2: Use while loop to count frequencies
        while (start < n) {
            int end = start;

            // Move end pointer until number changes
            while (end < n && nums[end] == nums[start]) {
                end++;
            }

            int freq = end - start; // frequency of nums[start]
            freqList.add(new int[]{nums[start], freq});

            start = end; // move start to the next unique element
        }

        // Step 3: Sort by frequency in descending order
        freqList.sort((a, b) -> Integer.compare(b[1], a[1]));

        // Step 4: Collect top k frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freqList.get(i)[0];
        }

        return result;
    }
}