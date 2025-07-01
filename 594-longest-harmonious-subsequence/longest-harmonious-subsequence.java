class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0; // Initialize to 0 to handle no harmonious case
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int len = map.get(key) + map.get(key + 1);
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
