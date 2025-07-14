class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count bulls and prepare map from unmatched secret characters
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                char s = secret.charAt(i);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        // Step 2: Count cows from unmatched guess characters
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                char g = guess.charAt(i);
                if (map.containsKey(g) && map.get(g) > 0) {
                    cows++;
                    map.put(g, map.get(g) - 1);
                }
            }
        }

        return bulls + "A" + cows + "B";
    }
}
