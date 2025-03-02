import java.util.*;

class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> validStrings(int n) {
        solve("", n);
        return ans;
    }

    public void solve(String s, int n) {
        if (s.length() == n) {
            ans.add(s);
            return;
        }

        // Add '1' and recurse
        solve(s + '1', n);

        // Add '0' only if the previous character is not '0'
        if (s.isEmpty() || s.charAt(s.length() - 1) != '0') {
            solve(s + '0', n);
        }
    }

    
}
