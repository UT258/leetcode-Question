import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        // A triangle requires at least 3 sides.
        if (nums == null || nums.length < 3) {
            return 0;
        }

        // 1. Sort the array. This is key to the optimization.
        Arrays.sort(nums);

        int count = 0;
        int n = nums.length;

        // 2. Iterate from the back, fixing the largest side 'c'.
        for (int i = n - 1; i >= 2; i--) {
            int c = nums[i];
            
            // 3. Use two pointers to find pairs 'a' and 'b'.
            int left = 0;
            int right = i - 1;

            while (left < right) {
                int a = nums[left];
                int b = nums[right];

                if (a + b > c) {
                    // If this pair is valid, all pairs between left and right are also valid.
                    count += (right - left);
                    right--; // Try a smaller 'b' to find more triangles.
                } else {
                    // The sum is too small, we need a larger 'a'.
                    left++;
                }
            }
        }

        return count;
    }
}