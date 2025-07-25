class Solution {

    public int xorAllNums(int[] nums1, int[] nums2) {
        // Get lengths of arrays
        int len1 = nums1.length;
        int len2 = nums2.length;

        // Map to store frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();

        // Add frequencies for nums1 elements
        // Each element appears n2 times in final result
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + len2);
        }

        // Add frequencies for nums2 elements
        // Each element appears n1 times in final result
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + len1);
        }

        // XOR numbers that appear odd number of times
        int ans = 0;
        for (int num : freq.keySet()) {
            if ((freq.get(num)  & 1) ==1) {
                ans ^= num;
            }
        }

        return ans;
    }
}