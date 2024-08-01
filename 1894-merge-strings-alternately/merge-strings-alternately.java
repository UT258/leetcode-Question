class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Using two pointers and a boolean variable to insert alternately
        boolean alternate = true; // for alternate insertion
        StringBuilder ans = new StringBuilder();
        // Take two pointers i and j
        int i = 0; // pointer for word1
        int j = 0; // pointer for word2
        
        while (i < word1.length() && j < word2.length()) {
            if (alternate) {
                ans.append(word1.charAt(i));
                i++;
            } else {
                ans.append(word2.charAt(j)); // Corrected to use j
                j++;
            }
            alternate = !alternate;
        }
        
        // Add the remaining characters in the answer
        while (i < word1.length()) {
            ans.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            ans.append(word2.charAt(j));
            j++;
        }
        
        return ans.toString();   
    }
}
