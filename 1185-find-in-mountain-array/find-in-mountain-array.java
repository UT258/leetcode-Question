/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findPeakElement(MountainArray nums) {
        // Use binary search to find the peak element
        int start = 0, end = nums.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) > nums.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; // Peak index
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakElement(mountainArr);

        // Try to find the target in the left (ascending) part
        int index = binarySearch(mountainArr, 0, peak, target, true);
        if (index != -1) return index;

        // Try to find the target in the right (descending) part
        return binarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target, false);
    }

    private int binarySearch(MountainArray arr, int start, int end, int target, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = arr.get(mid);

            if (midVal == target) return mid;

            if (ascending) { // Normal binary search in increasing order
                if (midVal < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { // Reverse binary search in decreasing order
                if (midVal > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1; // Not found
    }
}
