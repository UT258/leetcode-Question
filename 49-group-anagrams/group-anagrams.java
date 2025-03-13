import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to char array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray); // Sorted string as key
            
            // If key does not exist, create new list
            map.putIfAbsent(key, new ArrayList<>());
            // Add original string to the correct group
            map.get(key).add(s);
        }
        
        // Return the grouped anagrams
        return new ArrayList<>(map.values());
    }
}
