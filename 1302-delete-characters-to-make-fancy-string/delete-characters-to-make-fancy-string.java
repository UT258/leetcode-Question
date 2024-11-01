class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        if(s.length()<3)
        {
            return s;
        }

        ans.append(s.charAt(0));
        ans.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != ans.charAt(ans.length() - 1) || s.charAt(i) != ans.charAt(ans.length() - 2)) {
                // if they are then frq is still 2
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();

    }
}