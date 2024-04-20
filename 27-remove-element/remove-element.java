class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        if (nums.length <= 1) {
            return nums.length == 1 && nums[0] == val ? 0 : nums.length;
        }
        while (i < j) {
            if (nums[i] != val) {
                i++;
            } else {
                // Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums[i] == val ? i : i + 1;

    }
}