class Solution {
    public int findMin(int[] nums) {
        int bpoint = pivot(nums);
        // if no pivot found, array is not rotated
        if (bpoint == -1 || bpoint == nums.length - 1) {
            return nums[0];
        }
        return nums[bpoint + 1];
    }

    public int pivot(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 1) standard pivot checks
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // 2) all three are equal → shrink both ends
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                // check start
                if (start < end && nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;

                // check end
                if (end > start && nums[end - 1] > nums[end]) {
                    return end - 1;
                }
                end--;
            }
            // 3) decide which side to search
            else if (nums[start] <= nums[mid]) {
                // left side is sorted, pivot on right
                start = mid + 1;
            }
            else {
                // right side is sorted, pivot on left
                end = mid - 1;
            }
        }

        // no pivot found
        return -1;
    }
}
