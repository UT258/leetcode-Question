class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String s : words) {
            if (Startswith(s, pref)) {
                count++;
            }
        }
        return count;

    }

    public boolean Startswith(String words, String s) {
        if(s.length()>words.length())
        {
            return false;
        }
        // move till the prefix length and if they are equal or not
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != words.charAt(i)) {
                return false;
            }

        }

        return true;
    }
}