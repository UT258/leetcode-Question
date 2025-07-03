class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        String gen = "a";

        for (int i = 1; gen.length() <= k; i++) {
            StringBuilder newPart = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                char shifted = (char)(word.charAt(j) + 1);
                newPart.append(shifted);
            }
            word += newPart.toString();
            gen += newPart.toString();
        }

        return gen.charAt(k-1);
    }
}
