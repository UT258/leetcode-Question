import java.util.*;

class Solution {
    public int sumOfPower(int[] nums) {
        final long MOD = 1_000_000_007L;
        Arrays.sort(nums);

        long ans = 0L;
        long s = 0L; // running sum of minimums of all groups formed so far

        for (int v : nums) {
            long x = v % MOD;

            // contrib = x^2 * (sum of minimums for all groups where x is the maximum)
            //          = x^2 * (x + s)
            long contrib = ( (x * x) % MOD ) * ((x + s) % MOD) % MOD;
            ans = (ans + contrib) % MOD;

            // Update s for next iterations:
            // Every existing group can be extended with x (min unchanged),
            // plus the singleton group {x}.
            s = ( (2L * s) % MOD + x ) % MOD;
        }
        return (int)(ans % MOD);
    }
}
