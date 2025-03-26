class Solution {
    public void sortColors(int[] nums) {
        int arr[] = new int[3];
        for (int n : nums) {
            arr[n]++;
        }

        int k = 0;

        for (int i = arr[0]; i != 0; i--)
            nums[k++] = 0;
        for (int i = arr[1]; i != 0; i--)
            nums[k++] = 1;
        for (int i = arr[2]; i != 0; i--)
            nums[k++] = 2;

    }
}