import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Array length must be even for equal-size partition.");
        }
        int k = n / 2;
        long totalSum = 0;
        for (int v : nums) totalSum += v;

        // Split into two halves
        int n1 = n / 2;
        int n2 = n - n1; // also n/2
        int[] A = Arrays.copyOfRange(nums, 0, n1);
        int[] B = Arrays.copyOfRange(nums, n1, n);

        // 1) Enumerate subsets of A
        // sumsAByCount[c] holds List<Long> of sums of subsets of size c from A
        @SuppressWarnings("unchecked")
        List<Long>[] sumsAByCount = new List[n1 + 1];
        for (int i = 0; i <= n1; i++) sumsAByCount[i] = new ArrayList<>();
        int totalSubsA = 1 << n1;
        for (int mask = 0; mask < totalSubsA; mask++) {
            long sumA = 0;
            int cnt = 0;
            for (int bit = 0; bit < n1; bit++) {
                if ((mask & (1 << bit)) != 0) {
                    sumA += A[bit];
                    cnt++;
                }
            }
            sumsAByCount[cnt].add(sumA);
        }

        // 2) Enumerate subsets of B
        @SuppressWarnings("unchecked")
        List<Long>[] sumsBByCount = new List[n2 + 1];
        for (int i = 0; i <= n2; i++) sumsBByCount[i] = new ArrayList<>();
        int totalSubsB = 1 << n2;
        for (int mask = 0; mask < totalSubsB; mask++) {
            long sumB = 0;
            int cnt = 0;
            for (int bit = 0; bit < n2; bit++) {
                if ((mask & (1 << bit)) != 0) {
                    sumB += B[bit];
                    cnt++;
                }
            }
            sumsBByCount[cnt].add(sumB);
        }

        // 3) Sort each sumsBByCount list for binary search
        for (int cnt = 0; cnt <= n2; cnt++) {
            Collections.sort(sumsBByCount[cnt]);
        }

        long minDiff = Long.MAX_VALUE;

        // 4) Combine: pick i from A and k-i from B
        for (int i = 0; i <= n1; i++) {
            int j = k - i;
            if (j < 0 || j > n2) continue;
            List<Long> listA = sumsAByCount[i];
            List<Long> listB = sumsBByCount[j];
            if (listA.isEmpty() || listB.isEmpty()) continue;
            // For each sumA in listA, binary-search best sumB in listB
            for (long sumA : listA) {
                // We want sumA + sumB close to totalSum/2
                double targetB = (totalSum / 2.0) - sumA;
                // Binary search in listB for floor or insertion point
                int idx = Collections.binarySearch(listB, (long)Math.floor(targetB));
                if (idx < 0) idx = -idx - 1;
                // Check idx, idx-1 (and optionally idx+1) if valid
                for (int t = idx - 1; t <= idx + 1; t++) {
                    if (t >= 0 && t < listB.size()) {
                        long sumB = listB.get(t);
                        long subsetSum = sumA + sumB;
                        long diff = Math.abs(totalSum - 2 * subsetSum);
                        if (diff < minDiff) {
                            minDiff = diff;
                            if (minDiff == 0) break;
                        }
                    }
                }
                if (minDiff == 0) break;
            }
            if (minDiff == 0) break;
        }

        // minDiff fits in int if values moderate; otherwise cast carefully
        return (int)minDiff;
    }
}
