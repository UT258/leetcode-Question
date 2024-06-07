class Solution {
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length() / 2).toLowerCase();
        String b = s.substring(s.length() / 2, s.length()).toLowerCase();
        if (vowel(a) == vowel(b)) {
            return true;
        }
        return false;

    }

    public static int vowel(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                count++;
            }

        }
        return count;
    }
}