import java.util.*;

class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int partLength = part.length();
        
        for (char ch : s.toCharArray()) {
            st.push(ch);
            
            // Check if the top `partLength` characters match `part`
            if (st.size() >= partLength) {
                boolean match = true;
                for (int i = 0; i < partLength; i++) {
                    if (st.get(st.size() - partLength + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                
                // Remove `part` from stack
                if (match) {
                    for (int i = 0; i < partLength; i++) {
                        st.pop();
                    }
                }
            }
        }

        // Convert stack to string
        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeOccurrences("daabcbaabcbc", "abc")); // Output: "dab"
        System.out.println(sol.removeOccurrences("axxxxyyyyb", "xy"));    // Output: "ab"
    }
}
