class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int white = 0;
        while (j < blocks.length()) {
            if (blocks.charAt(j) == 'W') {
                white++;
            }
            if (j - i + 1 == k) {
                // if the length ==k then take the no of whites in the current substring
                min = Math.min(min, white);
            }
            if (j - i + 1 > k) {
                // we have to reduce the window size
                // but if the char is white then we need to decrease white count as well
                if (blocks.charAt(i) == 'W') {
                    white--;// reduce the white count
                    min = Math.min(min, white);

                }
                i++;

            }
            j++;
        }
        return min;

    }
}