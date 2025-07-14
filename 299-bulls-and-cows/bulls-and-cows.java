class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretFreq = new int[10]; // freq of digits 0–9 in secret
        int[] guessFreq = new int[10];  // freq of digits 0–9 in guess

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                // Store unmatched digits for cow calculation
                secretFreq[s - '0']++;
                guessFreq[g - '0']++;
            }
        }

        // Count cows: for each digit, take the minimum of secret and guess frequencies
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
