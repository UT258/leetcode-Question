class Solution {
    class Pair {
        int val;
        int diff;

        Pair(int val, int diff) {
            this.val = val;
            this.diff = diff;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            // Sort by largest diff first, then by larger value if tie
            if (b.diff != a.diff) return Integer.compare(b.diff, a.diff);
            return Integer.compare(b.val, a.val);
        });

        for (int n : arr) {
            pq.add(new Pair(n, Math.abs(n - x)));
            if (pq.size() > k) {
                pq.poll(); // Remove farthest
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().val);
        }

        Collections.sort(result); // Optional: problem may ask for sorted result
        return result;
    }
}