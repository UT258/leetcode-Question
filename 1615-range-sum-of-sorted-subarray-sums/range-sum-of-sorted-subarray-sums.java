class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int M=(int) Math.pow(10,9)+7;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the priority queue with the initial subarray sums
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        int result = 0;

        for (int i = 1; i <= right; i++) {
            int[] current = pq.poll();

            // If the current index is within the desired range, add the value to the result
            if (i >= left) {
                result = (result + current[0]) % M;
            }

            // If index is less than the last index, increment it and add the new subarray sum to the queue
            if (current[1] < n - 1) {
                pq.add(new int[]{current[0] + nums[current[1] + 1], current[1] + 1});
            }
        }
        return result;
 
    }
}