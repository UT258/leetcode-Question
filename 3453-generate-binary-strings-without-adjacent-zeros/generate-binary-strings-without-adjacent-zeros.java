import java.util.*;

class Solution {

    public List<String> validStrings(int n) {
        return solve("", n);
    }

    public List<String> solve(String s, int n) {
        List<String> res = new ArrayList<>();

        if (s.length() == n) {
            res.add(s);
            return res;
        }

        // Always append '1'
        res.addAll(solve(s + "1", n));

        // Append '0' only if previous character is not '0'
        if (s.isEmpty() || s.charAt(s.length() - 1) != '0') {
            res.addAll(solve(s + "0", n));
        }

        return res;
    }
}