class Solution {
public String longestPalindrome(String s) {
    int max = 0;
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) { // start j from i
            if (ispalindrome(s.substring(i, j + 1))) {
                if (j - i + 1 > max) { // check if the current length is greater than max
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
    }
    return ans;
}

public boolean ispalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) { // use '<' instead of '<='
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}

}