class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = 0;  // To store the maximum length of valid substring considering 'T'
        int maxF = 0;  // To store the maximum length of valid substring considering 'F'
        int countT = 0;  // Counter for 'T' characters in the current window
        int countF = 0;  // Counter for 'F' characters in the current window
        int left = 0;  // Left pointer for the sliding window

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }

            // If the number of changes required exceeds k, shrink the window
            while (Math.min(countT, countF) > k) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                left++;
            }

            // Calculate the maximum length of the valid window
            maxT = Math.max(maxT, right - left + 1);
            maxF = Math.max(maxF, right - left + 1);
        }

        // The result is the maximum of both maxT and maxF
        return Math.max(maxT, maxF);
    }
}