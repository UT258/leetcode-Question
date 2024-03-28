class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int maxlength = Integer.MIN_VALUE;
        int i =-1;
        int j = 0;
        // create a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            // put in the map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            // if the frquency is more than k then trim down
            while (map.get(nums[j]) > k) {
                i++;// move starting and remove this from the map
                map.put(nums[i], map.get(nums[i]) - 1);

            }
            maxlength = Math.max(maxlength, j - i );
            j++;
        }
        return maxlength;
    }
}