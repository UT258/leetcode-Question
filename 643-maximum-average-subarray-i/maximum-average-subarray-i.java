class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];

            // Check if we have reached the window size
            if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= nums[i]; // Slide the window forward by removing the element at index i
                i++;
            }
            j++;

        }
        return (double)max / k;

    }
}