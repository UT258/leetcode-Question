class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                i = k;
                break;
            }
        }
        if (i == -1)
            return;// non zero array
        int j = i + 1;

        while (j < nums.length) {
            if (nums[j] != 0) {
                // only swap when you are at zero
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }

    }
}