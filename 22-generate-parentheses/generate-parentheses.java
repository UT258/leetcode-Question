class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve("", n);
        return ans;
    }

    public boolean isvalid(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sum++;
            } else {
                sum--;// this means its a closing bracket it can be closed
            }
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }

    public void solve(String s, int n) {
        if (s.length() == 2 * n) {
            if (isvalid(s))
                ans.add(s);
            return;
        }

        s += '(';
        solve(s, n);
        s = s.substring(0, s.length() - 1); // remove the last character

        s += ')';
        solve(s, n);
    }
}