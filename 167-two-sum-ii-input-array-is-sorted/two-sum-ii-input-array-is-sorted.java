class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] ans = new int[2];

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ans[0] = i + 1;  // 1-based index
                ans[1] = j + 1;
                return ans;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return ans; // return empty array or default in case no solution found
    }
}
