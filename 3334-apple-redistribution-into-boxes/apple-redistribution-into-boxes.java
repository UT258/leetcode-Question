class Solution {
    private void reverse(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        reverse(capacity);
        int sum = Arrays.stream(apple).sum();
        int count = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (sum <= 0)

            {
                break;
            }
            sum -= capacity[i];
            count++;

        }
        return count;
    }
}