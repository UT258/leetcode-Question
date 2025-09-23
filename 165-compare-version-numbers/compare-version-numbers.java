class Solution {
    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] sec = version2.split("\\.");

        int n = Math.max(first.length, sec.length);

        for (int i = 0; i < n; i++) {
            int f = (i < first.length) ? Integer.parseInt(first[i]) : 0;
            int s = (i < sec.length) ? Integer.parseInt(sec[i]) : 0;

            if (f < s) return -1;
            if (f > s) return 1;
        }
        return 0;
    }
}
