import java.util.*;

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int count = 0;

        // Partition elements
        for (int num : nums) {
            if (num < pivot) {
                smaller.add(num);
            } else if (num > pivot) {
                greater.add(num);
            } else {
                count++;
            }
        }

        // Fill the result array
        int[] ans = new int[nums.length];
        int index = 0;

        for (int num : smaller) ans[index++] = num;
        while (count-- > 0) ans[index++] = pivot;
        for (int num : greater) ans[index++] = num;

        return ans;
    }
}
