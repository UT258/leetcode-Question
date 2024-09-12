class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean arr[] = new boolean[26];
        int count = 0;
        for (char c : allowed.toCharArray()) {
            arr[c - 'a'] = true;
        }
        for (String s : words) {
            boolean flag = true;
            for (char c : s.toCharArray()) {

                if (!arr[c - 'a']) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                count++;
            }
        }

        return count;

    }
}