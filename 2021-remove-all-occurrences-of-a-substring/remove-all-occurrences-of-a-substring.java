import java.util.*;

class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int partLength = part.length();
        
        for (char ch : s.toCharArray()) {
            st.push(ch);
            
            // Check if the last `partLength` characters match `part`
            if (st.size() >= partLength) {
                boolean match = true;
                for (int i = 0; i < partLength; i++) {
                    if (st.get(st.size() - partLength + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                
                // If match is found, pop `partLength` characters
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
    
    
}
