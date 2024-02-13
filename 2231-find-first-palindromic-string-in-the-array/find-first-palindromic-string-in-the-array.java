class Solution {
    public String firstPalindrome(String[] words) {
        for(String s:words)
        {
            if (ispalindrome (s))
            {
                return s;
            }
        }
        return "";
        
    }
    public static boolean ispalindrome(String s){

        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
            {
                return false;
            }
        }
        return true;
    }
}