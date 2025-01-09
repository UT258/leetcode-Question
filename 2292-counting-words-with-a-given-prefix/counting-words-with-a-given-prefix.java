class Solution {
    public int prefixCount(String[] words, String pref) {
        return (int)Arrays.stream(words).filter(s->s.startsWith(pref)).count();
        
    }
}