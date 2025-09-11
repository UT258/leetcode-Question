class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place numbers in their correct index (1 → index 0, 2 → index 1, ...)
        for (int i = 0; i < n; ) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        // Find first mismatch
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
