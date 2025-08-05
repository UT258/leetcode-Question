import java.util.*;

class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        return solve(s1, s2);
    }

    private boolean solve(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Early pruning: check if both strings have the same characters


        int n = s1.length();
        for (int i = 1; i < n; i++) {
            boolean noSwap = solve(s1.substring(0, i), s2.substring(0, i)) &&
                             solve(s1.substring(i), s2.substring(i));

            boolean swap = solve(s1.substring(0, i), s2.substring(n - i)) &&
                           solve(s1.substring(i), s2.substring(0, n - i));

            if (noSwap || swap) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}
