class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for (int temp : gifts) {
            p.add(temp);
        }
        // getting the maximum one
        for (int i = 0; i < k; i++) {
            int ans = p.peek();
            p.remove(ans);
            p.add((int) Math.sqrt(ans));

        }
        long sum = 0;
        for (int a : p) {
            sum += a;
        }
        return sum;

    }
}