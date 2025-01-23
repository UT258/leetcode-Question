class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Map every element in nums2 to its index
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int min = -1;
            int j = map.get(nums1[i]); // Get the index of nums1[i] in nums2
            for (j = j + 1; j < nums2.length; j++) { // Start from the next index
                if (nums2[j] > nums1[i]) { // Find the next greater element
                    min = nums2[j];
                    break; // Exit the loop after finding the next greater element
                }
            }
            ans[i] = min; // Assign the result to the answer array
        }
        return ans;
    }
}
