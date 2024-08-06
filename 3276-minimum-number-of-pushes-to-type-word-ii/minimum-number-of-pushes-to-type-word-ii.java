class Solution {
    public int minimumPushes(String word) {
Integer[] ans = new Integer[26];
        Arrays.fill(ans, 0);
        
        // Count the frequency of each character
        for (char c : word.toCharArray()) {
            ans[c - 'a']++;
        }

        // Sort the frequencies in descending order
        Arrays.sort(ans, Collections.reverseOrder());

        int result = 0;
        // Calculate the minimum number of presses required
        for (int i = 0; i < 26; i++) {
            int fre = ans[i];
            //if (fre == 0) break; // Stop if frequency is 0
            int press = i / 8 + 1;
            result += press * fre;
        }

        return result;
}
}