class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Arrays.sort(nums); // Step 1: Sort the array

        ArrayList<int[]> list = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                list.add(new int[]{nums[i - 1], count});
                count = 1;
            }
        }
        // Add the last group
        list.add(new int[]{nums[nums.length - 1], count});

        // Step 2: Sort by frequency descending
        list.sort((a, b) -> Integer.compare(b[1], a[1]));

        // Step 3: Collect top k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];
        }

        return result;   
    }
}