class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //time o(n) space O(n) for stack and map
        int ans[] = new int[nums1.length];
        int greater[] = nge(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = greater[map.get(nums1[i])];//first it will  check the map and get the index of the element 
        }
        return ans;

    }

    private int[] nge(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int ans[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();

            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return ans;
    }
}