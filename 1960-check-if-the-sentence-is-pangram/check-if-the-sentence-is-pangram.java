class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char ch='a';ch<='z';ch++)
        {
           if(!sentence.contains(ch+""))
           {
             return false;
           }
        }
        return true;
        
    }
}