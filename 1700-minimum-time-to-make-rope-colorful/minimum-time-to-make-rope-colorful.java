class Solution {
    public int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;

        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                pq.add(neededTime[i]);
                if (i == colors.length() - 2 ) {
                    pq.add(neededTime[i + 1]);
                }
            } else {
                pq.add(neededTime[i]);
                while (pq.size() > 1) {
                    sum += pq.poll();
                }
                pq.clear();
            }
            while (pq.size() > 1) {
                    sum += pq.poll();
                }

        }

        return sum;
    }
}
