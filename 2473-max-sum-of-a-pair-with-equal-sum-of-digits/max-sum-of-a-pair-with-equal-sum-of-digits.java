import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1; // Default to -1 if no valid pair exists

        for (int num : nums) {
            int digitSum = sumDigit(num);

            // If there's already a number with this digit sum, update maxSum
            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, map.get(digitSum) + num);
                // Store the max value for this digit sum
                map.put(digitSum, Math.max(map.get(digitSum), num));
            } else {
                map.put(digitSum, num);
            }
        }
        return maxSum;
    }

    public int sumDigit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
